/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.view;

/**
 *
 * @author ketanmalik
 */
public class BookingView {

    private String booking_id;
    private String event_name;
    private String venue;
    private String date_time;
    private String screen;
    private String seats;
    private String price;
    private String booking_date;
    private String customer_name;
    private String customer_contact;

    public BookingView() {
    }

    public BookingView(String booking_id, String event_name, String venue, String date_time, String screen, String seats, String price, String booking_date, String customer_name, String customer_contact) {
        this.booking_id = booking_id;
        this.event_name = event_name;
        this.venue = venue;
        this.date_time = date_time;
        this.screen = screen;
        this.seats = seats;
        this.price = price;
        this.booking_date = booking_date;
        this.customer_name = customer_name;
        this.customer_contact = customer_contact;
    }

    public String getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_contact() {
        return customer_contact;
    }

    public void setCustomer_contact(String customer_contact) {
        this.customer_contact = customer_contact;
    }
    
    @Override
    public String toString() {
        return "Booking ID: " + this.booking_id;
    }
}
