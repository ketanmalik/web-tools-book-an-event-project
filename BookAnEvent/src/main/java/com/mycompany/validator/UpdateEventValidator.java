/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.validator;

import com.mycompany.pojo.Event;
import com.mycompany.utils.Util;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author ketanmalik
 */
@Component
public class UpdateEventValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Event.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Event event = (Event) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "event_name", "NotEmpty.updateEventForm.name", "Please enter a valid event name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "event_type", "NotEmpty.updateEventForm.type", "Please select a valid event type");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "event_cast", "NotEmpty.updateEventForm.cast", "Please enter a valid event cast");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "event_rating", "NotEmpty.updateEventForm.rating", "Please select a valid event rating");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "event_genre", "NotEmpty.updateEventForm.genre", "Please select a valid event genre");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "event_language", "NotEmpty.updateEventForm.language", "Please enter a valid event language");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "event_summary", "NotEmpty.updateEventForm.summary", "Please enter a valid event summary");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "event_duration", "NotEmpty.updateEventForm.duration", "Please enter a valid event duration");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "event_date", "NotEmpty.updateEventForm.date", "Please select a valid event date");
        
        if(event.getEvent_summary().length() > 2000) {
            errors.rejectValue("event_summary", "NotEmpty.updateEventForm.long_summary", "Event summary is too long");
        }
        
        if(event.getEvent_duration().length() > 0 && !Util.validEventDuration(event.getEvent_duration())) {
            errors.rejectValue("event_duration","NotEmpty.updateEventForm.invalid_duration", "Please enter a valid event duration in minutes");
        }
    }
}
