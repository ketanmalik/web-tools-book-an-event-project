/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern p = Pattern.compile("^[1-9]+$");
        Matcher m = p.matcher(duration);
        return m.matches();
    }
}
