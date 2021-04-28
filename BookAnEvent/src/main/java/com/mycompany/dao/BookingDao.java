/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.pojo.Booking;
import com.mycompany.pojo.Event;
import com.mycompany.pojo.User;
import com.mycompany.pojo.Venue;
import java.util.Date;

/**
 *
 * @author ketanmalik
 */
public class BookingDao extends DAO {

    public Booking saveBooking(Date date, String phone, int seats, int price, User user, Event event, Venue venue) {
        try {
            beginTransaction();
            Booking booking = new Booking(date, phone, seats, price, user, event, venue);
            getSession().save(booking);
            commit();
            return booking;
        } catch (Exception e) {
            rollback();
            System.out.println("Exception in saveBooking DAOOOOOOOOOOO: ");
            e.printStackTrace();
            return null;
        }
    }
}
