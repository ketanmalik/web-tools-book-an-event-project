/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.validator;

import com.mycompany.pojo.Booking;
import com.mycompany.pojo.Show;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ketanmalik
 */
public class BookingValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Booking.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Booking booking = (Booking) o;
        try {
            int seats = booking.getSeats();
            if (seats <= 0) {
                errors.rejectValue("seats", "NotEmpty.bookingForm.seats", "Please enter valid no. of seats to book");
            }
        } catch (Exception e) {
            System.out.println("Exception in bookingValidator (seats)");
            e.printStackTrace();
            errors.rejectValue("seats", "NotEmpty.bookingForm.seats", "Please enter valid no. of seats to book");
        }

        try {
            String phone = booking.getPhone();
            Pattern p = Pattern.compile("[0-9]{10}");
            if (phone != null && phone.length() > 0) {
                Matcher m = p.matcher(phone);
                if (!m.matches()) {
                    errors.rejectValue("phone", "NotEmpty.bookingForm.phone", "Please enter a valid phone number");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in bookingValidator (phone)");
            e.printStackTrace();
            errors.rejectValue("phone", "NotEmpty.bookingForm.phone", "Please enter a valid phone number");
        }
    }

    public void validateCustom(Errors errors, Booking booking, Show show) {
        try {
            int seats = booking.getSeats();
            int price_per_seat = show.getSeat_price();
            int price = seats * price_per_seat;
            if (price <= 0) {
                errors.rejectValue("price", "NotEmpty.bookingForm.price", "Please enter valid no. of seats to calculate price");
            }
        } catch (Exception e) {
            System.out.println("Exception in bookingCustomValidator (price)");
            e.printStackTrace();
            errors.rejectValue("price", "NotEmpty.bookingForm.price", "Please enter valid no. of seats to calculate price");
        }
    }
}
