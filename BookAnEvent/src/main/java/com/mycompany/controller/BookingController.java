/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dao.BookingDao;
import com.mycompany.dao.ShowDao;
import com.mycompany.dao.VenueDao;
import com.mycompany.pojo.Booking;
import com.mycompany.pojo.Event;
import com.mycompany.pojo.Show;
import com.mycompany.pojo.User;
import com.mycompany.pojo.Venue;
import com.mycompany.utils.Util;
import com.mycompany.validator.BookingValidator;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ketanmalik
 */
@Controller
public class BookingController {

    @Autowired
    BookingValidator bookingValidator;

    @InitBinder("show")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(bookingValidator);
    }

    @PostMapping("/step-3.htm")
    public ModelAndView verifyBookingDetails(HttpServletRequest request, HttpSession session, ShowDao showDao, Model model, VenueDao venueDao) {
        if (invalidSessionObj(session, "user")) {
            return sessionTimedOut(request);
        }
        int show_id = Integer.parseInt(request.getParameter("show-id"));
        try {
            int venue_id = Integer.parseInt(session.getAttribute("venue-id") + "");
            Venue requestedVenue = venueDao.getVenue(venue_id);
            if (requestedVenue == null) {
                System.out.println("Venue could not be found in verifyBookingDetails (Booking Controller)");
                return serverError(request, "We could not proceed with your booking.");
            }
            session.setAttribute("requestedVenue", requestedVenue);
            session.removeAttribute("venue-id");
        } catch (Exception e) {
            System.out.println("Exception in verifyBookingDetails (Booking Controller: )");
            e.printStackTrace();
            return serverError(request, "We could not proceed with your booking.");
        }

        Show selectedShow = showDao.getShowObj(show_id);
        session.setAttribute("selectedShow", selectedShow);
        Booking booking = new Booking();
        model.addAttribute("bookingForm", booking);
        return new ModelAndView("customer-details-view");
    }

    @PostMapping("/step-4.htm")
    public ModelAndView confirmBooking(@ModelAttribute("bookingForm") Booking booking, BindingResult result, HttpServletRequest request, HttpSession session, BookingDao bookingDao, ShowDao showDao) {
        if (invalidSessionObj(session, "user")) {
            return sessionTimedOut(request);
        }
        bookingValidator.validate(booking, result);
        if (result.hasErrors()) {
            return new ModelAndView("customer-details-view");
        }
        Show selectedShow = (Show) session.getAttribute("selectedShow");
        bookingValidator.validateCustom(result, booking, selectedShow);
        if (result.hasErrors()) {
            return new ModelAndView("customer-details-view");
        }
        try {
            Date booking_date = new Date();
            String phone = booking.getPhone();
            int seats = booking.getSeats();
            int price = seats * selectedShow.getSeat_price();
            User user = (User) session.getAttribute("user");
            Event event = (Event) session.getAttribute("requestedEvent");
            Venue venue = (Venue) session.getAttribute("requestedVenue");
            Booking savedBooking = bookingDao.saveBooking(booking_date, phone, seats, price, user, event, venue, selectedShow);

            if (savedBooking != null) {
                Show updatedShow = showDao.updateSeatsLeft(selectedShow.getShow_id(), seats);
                if (updatedShow == null) {
                    bookingDao.deleteBooking(savedBooking.getBooking_id());
                    request.setAttribute("errorMsg1", "Your booking could not be confirmed");
                    request.setAttribute("errorMsg2", "The show you selected ran out of seats. Please select a different show to book.");
                    return new ModelAndView("error-view");
                }
                Util.printSessionAttributes(session);
                session.removeAttribute("selectedCity");
                session.removeAttribute("requestedShows");
                session.removeAttribute("requestedVenue");
                session.removeAttribute("requestedEvent");
                session.removeAttribute("selectedShow");
                session.removeAttribute("selectedEvent");
                session.removeAttribute("eventsInCity");
                request.setAttribute("successMsg1", "Your booking has been confirmed.");
                request.setAttribute("successMsg2", "We hope you've had a wonderful experience and we wish to serve you soon.");
                return new ModelAndView("success-view");
            } else {
                return serverError(request, "Your booking could not be confirmed");
            }

        } catch (Exception e) {
            System.out.println("Exception in confirmBooking (BookingController): ");
            return serverError(request, "Your booking could not be confirmed");
        }
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
