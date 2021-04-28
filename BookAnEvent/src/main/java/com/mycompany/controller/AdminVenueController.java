/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dao.VenueDao;
import com.mycompany.pojo.Venue;
import com.mycompany.validator.VenueValidator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ketanmalik
 */
@Controller
public class AdminVenueController {

    @Autowired
    VenueValidator venueValidator;

    @InitBinder("venue")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(venueValidator);
        
    }

    @PostMapping("/add-venue.htm")
    public ModelAndView addVenue(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
        if (invalidSessionObj(session, "user")) {
            return sessionTimedOut(request);
        }
        Venue venue = new Venue();
        model.addAttribute("addVenueForm", venue);
        return new ModelAndView("add-venue-view");
    }

    @PostMapping("/delete-venue.htm")
    public ModelAndView deleteVenue(HttpServletRequest request, HttpServletResponse response, HttpSession session, VenueDao venueDao) {
        if (invalidSessionObj(session, "user")) {
            return sessionTimedOut(request);
        }
        int res = venueDao.deleteVenue(Integer.parseInt(request.getParameter("delete-venue")));
        if (res > 0) {
            List<Venue> venueList = venueDao.getVenueList();
            session.setAttribute("venueList", venueList);
            return new ModelAndView("manage-venues-view");
        } else {
            return serverError(request, "The venue could not be deleted.");
        }
    }

    @GetMapping("/manage-venues.htm")
    public ModelAndView updateViewsInSession(HttpServletRequest request, HttpSession session, VenueDao venueDao) {
        if (invalidSessionObj(session, "user")) {
            return sessionTimedOut(request);
        }
        List<Venue> venueList = venueDao.getVenueList();
        session.setAttribute("venueList", venueList);
        return new ModelAndView("manage-venues-view");
    }

    @PostMapping("/manage-venues.htm")
    public ModelAndView manageVenues(HttpServletRequest request, HttpServletResponse response, HttpSession session, VenueDao venueDao) {
        if (invalidSessionObj(session, "user")) {
            return sessionTimedOut(request);
        }
        List<Venue> venueList = venueDao.getVenueList();
        session.setAttribute("venueList", venueList);
        return new ModelAndView("manage-venues-view");
    }

    @PostMapping("/updated-venue.htm")
    public ModelAndView saveUpdatedVenue(@ModelAttribute("updateVenueForm") Venue venue, BindingResult result, Model model, HttpServletRequest request, HttpSession session, VenueDao venueDao) {
        venueValidator.validate(venue, result);
        if (result.hasErrors()) {
            return new ModelAndView("update-venue-view");
        } else {
            Venue sessionVenue = (Venue) session.getAttribute("venue");
            int res = venueDao.updateVenue(sessionVenue.getVenue_id(), venue);
            if (res == 1) {
                venue.setVenue_id(sessionVenue.getVenue_id());
                session.removeAttribute("venue");
                session.setAttribute("venue", venue);
                Venue obj = (Venue) session.getAttribute("venue");
                request.setAttribute("successMsg1", "Venue updated successfully.");
                request.setAttribute("successMsg2", "Please go back to dashboard to manage events, users, and venues.");
                return new ModelAndView("success-view");
            } else {
                return serverError(request, "The venue could not be updated.");
            }
        }
    }

    @PostMapping("/venue-added.htm")
    public ModelAndView saveVenue(@ModelAttribute("addVenueForm") Venue venue, BindingResult result, HttpServletRequest request, HttpSession session, VenueDao venueDao) {
        venueValidator.validate(venue, result);
        if (result.hasErrors()) {
            return new ModelAndView("add-venue-view");
        } else {
            int res = venueDao.saveVenue(venue);
            if (res == 1) {
                List<Venue> venueList = venueDao.getVenueList();
                session.setAttribute("eventList", venueList);
                request.setAttribute("successMsg1", "Venue added successfully.");
                request.setAttribute("successMsg2", "Please go back to dashboard to manage events, users, and venues.");
                return new ModelAndView("success-view");
            } else {
                return serverError(request, "The venue could not be added.");
            }
        }
    }

    @PostMapping("/update-venue.htm")
    public ModelAndView updateVenue(HttpServletRequest request, HttpServletResponse response, HttpSession session, VenueDao venueDao, Model model) {
        if (invalidSessionObj(session, "user")) {
            return sessionTimedOut(request);
        }
        int venue_id = Integer.parseInt(request.getParameter("update-venue"));
        Venue venue = venueDao.getVenue(venue_id);
//        System.out.println("Venue id: " + venue.getVenue_id());
//        System.out.println("Venue name: " + venue.getVenue_name());
//        System.out.println("Venue city: " + venue.getVenue_city());
//        System.out.println("Venue state: " + venue.getVenue_state());
//        System.out.println("Venue country: " + venue.getVenue_country());
//        System.out.println("Venue rows: " + venue.getVenue_rows());
//        System.out.println("Venue seat: " + venue.getSeat_per_row());
//        System.out.println("Venue seat price: " + venue.getSeat_price());

        if (venue == null) {
            if (session.getAttribute("venue") != null) {
                session.removeAttribute("venue");
            }
            return serverError(request, "The venue could not be updated.");
        }
        session.setAttribute("venue", venue);
        model.addAttribute("updateVenueForm", venue);
        return new ModelAndView("update-venue-view");
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
