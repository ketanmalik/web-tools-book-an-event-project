/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils;

import java.beans.PropertyEditorSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.web.bind.WebDataBinder;

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

//    public static void registerIntFormat(WebDataBinder binder) {
//        binder.registerCustomEditor(Integer.class, new CustomerIntEditor());
//    }
//
//    private static class CustomerIntEditor extends PropertyEditorSupport {
//
//        @Override
//        public String getAsText() {
//            Integer i = (Integer) this.getValue();
//            return i.toString();
//        }
//
//        @Override
//        public void setAsText(String str) {
//            if (str == null || str.trim().equals("")) {
//                this.setValue(0);
//            } else {
//                this.setValue(Integer.parseInt(str));
//            }
//        }
//    }
}
