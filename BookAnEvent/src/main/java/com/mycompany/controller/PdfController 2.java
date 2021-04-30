/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.pojo.Booking;
import com.mycompany.pojo.Show;
import com.mycompany.pojo.Venue;
import com.mycompany.view.BookingView;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ketanmalik
 */
@Controller
public class PdfController {

    @GetMapping("/booking.pdf")
    public ModelAndView generateBookingPdf(HttpSession session, Booking booking, Venue venue, Show show) {
        BookingView bookingPdf = (BookingView) session.getAttribute("bookingPdf");
        return new ModelAndView("booking-pdf", "bookingPdf", bookingPdf);
    }

    private void removeTempSessionAttributes(HttpSession session) {
        session.removeAttribute("selectedCity");
        session.removeAttribute("requestedShows");
        session.removeAttribute("requestedVenue");
        session.removeAttribute("requestedEvent");
        session.removeAttribute("selectedShow");
        session.removeAttribute("selectedEvent");
        session.removeAttribute("eventsInCity");
    }
}
