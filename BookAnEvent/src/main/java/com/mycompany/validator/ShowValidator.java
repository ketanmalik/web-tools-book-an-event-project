/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.validator;

import com.mycompany.pojo.Show;
import com.mycompany.utils.Util;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author ketanmalik
 */
public class ShowValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Show.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Show show = (Show) o;
        String show_time = "";
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "seat_price", "NotEmpty.addShowForm.seat_price", "Please enter valid seat price");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "total_rows", "NotEmpty.addShowForm.total_rows", "Please enter valid number of rows");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "seats_per_row", "NotEmpty.addShowForm.seats_per_row", "Please enter valid seats/row");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "screen", "NotEmpty.addShowForm.screen", "Please enter a valid screen/auditorium");

        try {
            show_time = show.getShow_time();
            Pattern p = Pattern.compile("[0-9]{2}:[0-9]{2}(AM|PM)$");
            Matcher m = p.matcher(show_time);
            if (show_time.trim().equals("") || !m.matches()) {
                errors.rejectValue("show_time", "NotEmpty.addShowForm.invalid_show_time", "Please enter show time in valid format (09:00AM)");
            }
        } catch (Exception e) {
            System.out.println("Exception in showValidator (showTime)");
            e.printStackTrace();
            errors.rejectValue("show_time", "NotEmpty.addShowForm.invalid_show_time", "Please enter show time in valid format (09:00AM)");
        }

        try {
            Date showDate = show.getShow_date();
            if (showDate == null || showDate.before(new Date())) {
                errors.rejectValue("show_date", "NotEmpty.addShowForm.show_date", "Please select a valid show date");
            }
        } catch (Exception e) {
            errors.rejectValue("show_date", "NotEmpty.addShowForm.show_date", "Please select a valid show date");
        }
    }
}
