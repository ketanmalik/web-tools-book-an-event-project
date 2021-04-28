/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ketanmalik
 */
public class Booking {

    private int booking_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date booking_date;
    private String phone;
    private Integer seats;
    private Integer price;
    private User user;
    private Event event;
    private Venue venue;

    public Booking() {
    }

    public Booking(Date booking_date, String phone, Integer seats, Integer price, User user, Event event, Venue venue) {
        this.booking_date = booking_date;
        this.phone = phone;
        this.seats = seats;
        this.price = price;
        this.user = user;
        this.event = event;
        this.venue = venue;
    }
    
    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
