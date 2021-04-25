/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.io.Serializable;



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
    private Integer seat_price;
    private Integer venue_rows;
    private Integer seat_per_row;

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

    public Integer getSeat_price() {
        return seat_price;
    }

    public void setSeat_price(Integer seat_price) {
        this.seat_price = seat_price;
    }

    public Integer getVenue_rows() {
        return venue_rows;
    }

    public void setVenue_rows(Integer venue_rows) {
        this.venue_rows = venue_rows;
    }

    public Integer getSeat_per_row() {
        return seat_per_row;
    }

    public void setSeat_per_row(Integer seat_per_row) {
        this.seat_per_row = seat_per_row;
    }
}
