/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ketanmalik
 */
public class Event implements Serializable {
    private int event_id;
    private String event_name;
    private String event_type;
    private String event_cast;
    private String event_rating;
    private String event_genre;
    private String event_language;
    private String event_summary;
    private String event_duration;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date event_date;

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getEvent_cast() {
        return event_cast;
    }

    public void setEvent_cast(String event_cast) {
        this.event_cast = event_cast;
    }
    
    public String getEvent_rating() {
        return event_rating;
    }

    public void setEvent_rating(String event_rating) {
        this.event_rating = event_rating;
    }

    public String getEvent_genre() {
        return event_genre;
    }

    public void setEvent_genre(String event_genre) {
        this.event_genre = event_genre;
    }

    public String getEvent_language() {
        return event_language;
    }

    public void setEvent_language(String event_language) {
        this.event_language = event_language;
    }

    public String getEvent_summary() {
        return event_summary;
    }

    public void setEvent_summary(String event_summary) {
        this.event_summary = event_summary;
    }

    public String getEvent_duration() {
        return event_duration;
    }

    public void setEvent_duration(String event_duration) {
        this.event_duration = event_duration;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }
}
