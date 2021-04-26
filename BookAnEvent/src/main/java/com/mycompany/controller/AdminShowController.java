/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dao.EventDao;
import com.mycompany.dao.ShowDao;
import com.mycompany.dao.VenueDao;
import com.mycompany.pojo.Event;
import com.mycompany.pojo.Show;
import com.mycompany.pojo.Venue;
import com.mycompany.validator.ShowValidator;
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
public class AdminShowController {

    @Autowired
    ShowValidator showValidator;

    @InitBinder("show")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(showValidator);
    }

    @PostMapping("/add-show.htm")
    public ModelAndView addShow(HttpServletRequest request, HttpSession session, Model model) {
        if (invalidSessionObj(session, "user")) {
            return sessionTimedOut(request);
        }
        Show show = new Show();
        model.addAttribute("addShowForm", show);
        session.setAttribute("venue-id", request.getParameter("add-show"));
        return new ModelAndView("add-show-view");
    }

    @PostMapping("/show-added.htm")
    public ModelAndView saveShow(@ModelAttribute("addShowForm") Show show, BindingResult result, HttpServletRequest request, HttpSession session, ShowDao showDao, EventDao eventDao, VenueDao venueDao) {
        showValidator.validate(show, result);
        if (result.hasErrors()) {
            return new ModelAndView("add-show-view");
        } else {
            int event_id = Integer.parseInt(request.getParameter("event-name"));
            int venue_id = Integer.parseInt(session.getAttribute("venue-id") + "");
            Event event = eventDao.getEvent(event_id);
            Venue venue = venueDao.getVenue(venue_id);
            show.setEvent(event);
            show.setVenue(venue);
            session.removeAttribute("venue-id");
            int res = showDao.addShow(show);
            if (res == 1) {
//                List<Show> venueList = venueDao.getVenueList();
//                session.setAttribute("eventList", venueList);
                request.setAttribute("successMsg1", "Show added successfully.");
                request.setAttribute("successMsg2", "Please go back to dashboard to manage events, users, and venues.");
                return new ModelAndView("success-view");
            } else {
                return serverError(request, "The show could not be added.");
            }
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
