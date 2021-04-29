/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



/**
 *
 * @author ketanmalik
 */
public class Venue implements Serializable {
    private int venue_id;
    private String venue_name;
    private String venue_city;
    private String venue_state;
    private String venue_country;
    private Set<Event> events = new HashSet<>(0);

    public int getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(int venue_id) {
        this.venue_id = venue_id;
    }

    public String getVenue_name() {
        return venue_name;
    }

    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }

    public String getVenue_city() {
        return venue_city;
    }

    public void setVenue_city(String venue_city) {
        this.venue_city = venue_city;
    }

    public String getVenue_state() {
        return venue_state;
    }

    public void setVenue_state(String venue_state) {
        this.venue_state = venue_state;
    }

    public String getVenue_country() {
        return venue_country;
    }

    public void setVenue_country(String venue_country) {
        this.venue_country = venue_country;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
