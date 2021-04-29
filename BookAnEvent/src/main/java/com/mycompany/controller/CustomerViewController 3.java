/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dao.EventDao;
import com.mycompany.dao.ShowDao;
import com.mycompany.pojo.Event;
import com.mycompany.pojo.Show;
import com.mycompany.utils.Util;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author ketanmalik
 */
@Controller
public class CustomerViewController {

    @GetMapping("/get-events.htm")
    @ResponseBody
    public String getEventsInCity(HttpServletRequest request, HttpServletResponse response, HttpSession session, ShowDao showDao) {
        List<Event> eventsList = showDao.getEventsInCity(request.getParameter("city"));
        String eventsInCity = "";
        for (int i = 0; i < eventsList.size(); i++) {
            eventsInCity += eventsList.get(i).getEvent_name() + ",";
        }
        if (eventsInCity.length() > 0) {
            eventsInCity = eventsInCity.substring(0, eventsInCity.length() - 1);
        }
        session.setAttribute("eventsInCity", eventsList);
        return eventsInCity;
    }

    @PostMapping("/step-2.htm")
    public ModelAndView selectShow(HttpServletRequest request, HttpServletResponse response, HttpSession session, EventDao eventDao, ShowDao showDao) {
        session.removeAttribute("cityError");
        session.removeAttribute("eventError");
        if (invalidSessionObj(session, "user")) {
            return sessionTimedOut(request);
        }
        String city = request.getParameter("city");
        String event = request.getParameter("event");
        boolean errors = false;
        if (city == null || (city != null && city.equals(""))) {
            errors = true;
            session.setAttribute("cityError", "Please select a city");
        }
        if (event == null || (event != null && event.equals(""))) {
            errors = true;
            session.setAttribute("eventError", "Please select an event");
        }
        if (errors) {
            return new ModelAndView(new RedirectView("/log-in-user.htm", true));
        }
        session.setAttribute("selectedCity", city);
        session.setAttribute("selectedEvent", event);
        Event requestedEvent = eventDao.getEventFromName(event);
        List<Show> shows = showDao.getShow(city, event);
        session.setAttribute("requestedEvent", requestedEvent);
        session.setAttribute("requestedShows", shows);
        if (shows == null) {
            return serverError(request, "We could not retrieve any shows at the moment.");
        }
        return new ModelAndView("customer-select-view");
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
