/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils;

import java.beans.PropertyEditorSupport;
import org.springframework.web.bind.WebDataBinder;

/**
 *
 * @author ketanmalik
 */
public class Util {

    public static void registerIntFormat(WebDataBinder binder) {
        System.out.println("binder");
        binder.registerCustomEditor(Integer.class, new CustomerIntEditor());
    }

    private static class CustomerIntEditor extends PropertyEditorSupport {

        @Override
        public String getAsText() {
            Integer i = (Integer) this.getValue();
            System.out.println("get: " + i);
            return i.toString();
        }

        @Override
        public void setAsText(String str) {
            System.out.println("str: " + str);
            System.out.println("str: " + str);
            if (str == null || str.trim().equals("")) {
                this.setValue(0);
            } else {
                this.setValue(Integer.parseInt(str));
            }
        }
    }

}
