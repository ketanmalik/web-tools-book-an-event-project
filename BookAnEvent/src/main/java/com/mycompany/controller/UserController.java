/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dao.UserDao;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ketanmalik
 */
@Controller
public class UserController {

    @PostMapping("/sign-up-success.htm")
    public ModelAndView signUpUser(HttpServletRequest request, HttpServletResponse response, UserDao userDao) {
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        Pattern p = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9]+.[a-zA-Z]+$");
        Matcher m = p.matcher(email);
        if (fName.trim().equals("") || lName.trim().equals("") || email.trim().equals("")
                || password.trim().equals("") || city.trim().equals("") || state.trim().equals("") || !m.matches()) {
            request.setAttribute("errorMsg1", "You could not be signed up.");
            request.setAttribute("errorMsg2", "Some fields in the sign up form were invalid. Please try again.");
            return new ModelAndView("error-view");
        }
        int res = userDao.addUser(fName, lName, email, password, city, state, country, "customer");
        if (res == -1) {
            request.setAttribute("errorMsg1", "You could not be signed up.");
            request.setAttribute("errorMsg2", "A user already exists with this email. Please try to log in instead.");
            return new ModelAndView("error-view");
        }
        if (res == 1) {
            request.setAttribute("successMsg1", "You have signed up successfully");
            request.setAttribute("successMsg2", "Please log in from home page to enjoy our services");
            return new ModelAndView("success-view");
        }
        request.setAttribute("errorMsg1", "You could not be signed up");
        request.setAttribute("errorMsg2", "There was a problem in reaching out to our servers. Please try again later.");
        return new ModelAndView("error-view", "errorMsg", "There was some problem while signing up. Please try again later.");
    }
}
