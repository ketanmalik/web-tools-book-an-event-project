/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dao.EventDao;
import com.mycompany.pojo.Event;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ketanmalik
 */
@Controller
public class AdminController {

    @PostMapping("/add-event.htm")
    public ModelAndView addEvent(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        if (invalidSessionObj(session, "user")) {
            return sessionTimedOut(request);
        }
        return new ModelAndView("add-event-view");
    }

    @PostMapping("/delete-event.htm")
    public ModelAndView deleteEvent(HttpServletRequest request, HttpServletResponse response, HttpSession session, EventDao eventDao) {
        if (invalidSessionObj(session, "user")) {
            return sessionTimedOut(request);
        }
        int res = eventDao.deleteEvent(Integer.parseInt(request.getParameter("delete-event")));
        if(res > 0) {
            List<Event> eventList = eventDao.getEventList();
            session.setAttribute("eventList", eventList);
        }
        return new ModelAndView("manage-events-view");
    }

    @PostMapping("event-added.htm")
    public ModelAndView saveEvent(HttpServletRequest request, HttpServletResponse response, HttpSession session, EventDao eventDao) throws ParseException {
        if (invalidSessionObj(session, "user")) {
            return sessionTimedOut(request);
        }
        String event_name = request.getParameter("event-name");
        String event_type = request.getParameter("event-type");
        String event_cast = request.getParameter("event-cast");
        String event_rating = request.getParameter("event-rating");
        String event_genre = request.getParameter("event-genre");
        String event_language = request.getParameter("event-language");
        String event_summary = request.getParameter("event-summary");
        String event_duration = request.getParameter("event-duration");
        String event_date = request.getParameter("event-date");

        if (event_name.trim().equals("") || event_type.trim().equals("") || event_cast.trim().equals("") || event_rating.trim().equals("") || event_genre.trim().equals("")
                || event_language.trim().equals("") || event_summary.trim().equals("") || event_duration.trim().equals("") || event_date.trim().equals("")) {

            request.setAttribute("errorMsg1", "New event could not be added.");
            request.setAttribute("errorMsg2", "Some of the fields you entered were invalid. Please try again.");
            return new ModelAndView("error-view");
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        int res = eventDao.saveEvent(event_name, event_type, event_cast, event_rating, event_genre,
                event_language, event_summary, Integer.parseInt(event_duration), formatter.parse(event_date));
        if (res > 0) {
            request.setAttribute("successMsg1", "New event added successfully.");
            request.setAttribute("successMsg2", "Please go back to dashboard to manage this newly added event.");
            return new ModelAndView("success-view");
        }
        return serverError(request);
    }

    @PostMapping("/manage-events.htm")
    public ModelAndView manageEvents(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        if (invalidSessionObj(session, "user")) {
            return sessionTimedOut(request);
        }
        return new ModelAndView("manage-events-view");
    }

    @PostMapping("/manage-venues.htm")
    public ModelAndView manageVenues(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        if (invalidSessionObj(session, "user")) {
            return sessionTimedOut(request);
        }
        return new ModelAndView("manage-venues-view");
    }

    public boolean invalidSessionObj(HttpSession session, String obj) {
        return session.getAttribute(obj) == null;
    }

    public ModelAndView sessionTimedOut(HttpServletRequest request) {
        request.setAttribute("errorMsg1", "Your session has been timed out.");
        request.setAttribute("errorMsg2", "Please log in again to start a new session.");
        return new ModelAndView("error-view");
    }

    public ModelAndView serverError(HttpServletRequest request) {
        request.setAttribute("errorMsg1", "New event could not be added.");
        request.setAttribute("errorMsg2", "There was a problem in reaching out to our servers. Please try again later.");
        return new ModelAndView("error-view");
    }
}
