/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ketanmalik
 */
public class Util {

    public static boolean validEmail(String email) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9]+.[a-zA-Z]+$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean validEventDuration(String duration) {
        Pattern p = Pattern.compile("^[1-9][0-9]+");
        Matcher m = p.matcher(duration);
        return m.matches();
    }

    public static void printSessionAttributes(HttpSession session) {
        System.out.println("--------Printing session attributes started--------");
        Enumeration<String> attributes = session.getAttributeNames();
        while (attributes.hasMoreElements()) {
            String attribute = (String) attributes.nextElement();
            System.out.println(attribute + " : " + session.getAttribute(attribute));
        }
        System.out.println("--------Printing session attributes completed--------");
    }
    
    public static String dateToString(Date date, String mode) {
        DateFormat dateFormat;
        if(mode.equals("date")) {
            dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        } else {
            dateFormat = new SimpleDateFormat("dd MMMM yyyy hh:mm:ss");
        }
        return dateFormat.format(date);
    }
}
