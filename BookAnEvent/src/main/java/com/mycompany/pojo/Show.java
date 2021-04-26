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
public class Show implements Serializable {

    private int show_id;
    private Event event;
    private Venue venue;
    private Integer seat_price;
    private Integer total_rows;
    private Integer seats_per_row;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date show_date;
    private String show_time;
    private String screen;

    public int getShow_id() {
        return show_id;
    }

    public void setShow_id(int show_id) {
        this.show_id = show_id;
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

    public Integer getSeat_price() {
        return seat_price;
    }

    public void setSeat_price(Integer seat_price) {
        this.seat_price = seat_price;
    }

    public Integer getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(Integer total_rows) {
        this.total_rows = total_rows;
    }

    public Integer getSeats_per_row() {
        return seats_per_row;
    }

    public void setSeats_per_row(Integer seats_per_row) {
        this.seats_per_row = seats_per_row;
    }

    public Date getShow_date() {
        return show_date;
    }

    public void setShow_date(Date show_date) {
        this.show_date = show_date;
    }

    public String getShow_time() {
        return show_time;
    }

    public void setShow_time(String show_time) {
        this.show_time = show_time;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }
}
