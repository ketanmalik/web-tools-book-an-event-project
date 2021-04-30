/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dao.BookingDao;
import com.mycompany.dao.ShowDao;
import com.mycompany.pojo.Booking;
import com.mycompany.pojo.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ketanmalik
 */
@Controller
public class UserBookingsController {

    @GetMapping("/user-bookings.htm")
    public ModelAndView userBookings(HttpServletRequest request, HttpSession session, BookingDao bookingDao) {
        if (invalidSessionObj(session, "user")) {
            return sessionTimedOut(request);
        }
        User user = (User) session.getAttribute("user");
        List<Booking> bookings = bookingDao.getBookings(user.getUser_id());
        session.setAttribute("bookings", bookings);
        return new ModelAndView("user-bookings-view");
    }

    @PostMapping("/cancel-booking.htm")
    public ModelAndView cancelBooking(HttpServletRequest request, HttpSession session, BookingDao bookingDao, ShowDao showDao) throws ParseException {
        if (invalidSessionObj(session, "user")) {
            return sessionTimedOut(request);
        }
        int booking_id = 0;
        try {
            booking_id = Integer.parseInt(request.getParameter("cancel-booking") + "");
        } catch (Exception e) {
            System.out.println("Exception in cancelBooking userbookingcontroller");
            e.printStackTrace();
            return serverError(request, "We could not retrieve your booking at the moment");
        }
        Booking booking = bookingDao.getBooking(booking_id);
        if (booking == null) {
            return serverError(request, "We could not retrieve your booking at the moment");
        }
        Date bookingDate = booking.getShow().getShow_date();
        Date todaysDate = new Date();
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        todaysDate = sdformat.parse(sdformat.format(todaysDate));
        bookingDate = sdformat.parse(sdformat.format(bookingDate));

        long diffInMillies = Math.abs(bookingDate.getTime() - todaysDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        if (diff < 3) {
            return new ModelAndView("user-bookings-view", "errorMsg", "Your booking cannot be cancelled because it is past the cancellation period.");
        }
        showDao.addSeats(booking.getShow().getShow_id(), booking.getSeats());
        bookingDao.deleteBooking(booking_id);
        User user = (User) session.getAttribute("user");
        List<Booking> bookings = bookingDao.getBookings(user.getUser_id());
        session.setAttribute("bookings", bookings);
        return new ModelAndView("user-bookings-view", "successMsg", "Your booking has been cancelled successfully!");
    }

    public boolean invalidSessionObj(HttpSession session, String obj) {
        return session.getAttribute(obj) == null;
    }

    public ModelAndView sessionTimedOut(HttpServletRequest request) {
        request.setAttribute("errorMsg1", "Your session has been timed out.");
        request.setAttribute("errorMsg2", "Please log in again to start a new session.");
        return new ModelAndView("error-view");
    }

    public ModelAndView serverError(HttpServletRequest request, String msg1) {
        request.setAttribute("errorMsg1", msg1);
        request.setAttribute("errorMsg2", "There was a problem in reaching out to our servers. Please try again later.");
        return new ModelAndView("error-view");
    }
}
