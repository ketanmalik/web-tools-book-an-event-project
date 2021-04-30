/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.validator;

import com.mycompany.pojo.Venue;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author ketanmalik
 */
public class VenueValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Venue.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Venue venue = (Venue) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "venue_name", "NotEmpty.addVenueForm.name", "Please enter a valid venue name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "venue_city", "NotEmpty.addVenueForm.city", "Please enter a valid venue city");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "venue_state", "NotEmpty.addVenueForm.state", "Please select a valid venue state");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "venue_country", "NotEmpty.addVenueForm.country", "Please enter a valid venue country");
    }
}
