/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ketanmalik
 */
@Controller
public class NavbarController {

    @GetMapping("/log-in.htm")
    public ModelAndView logInPage(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("log-in-view");
    }

    @GetMapping("/sign-up.htm")
    public ModelAndView signUpPage(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("sign-up-view");
    }
}
