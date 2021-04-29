/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.pojo.Booking;
import com.mycompany.pojo.Event;
import com.mycompany.pojo.Show;
import com.mycompany.pojo.User;
import com.mycompany.pojo.Venue;
import java.util.Date;
import org.hibernate.query.Query;

/**
 *
 * @author ketanmalik
 */
public class BookingDao extends DAO {

    public Booking saveBooking(Date date, String phone, int seats, int price, User user, Event event, Venue venue, Show show) {
        try {
            Show selectedShow = new Show(show.getShow_id(), show.getSeat_price(), show.getTotal_rows(), show.getSeats_per_row(), show.getShow_time(), show.getSeats_left(), show.getShow_date(), show.getScreen(), event, venue);
            Booking booking = new Booking(date, phone, seats, price, user, selectedShow);
            beginTransaction();
            getSession().save(booking);
            commit();
            return booking;
        } catch (Exception e) {
            rollback();
            System.out.println("Exception in saveBooking BookingDAO: ");
            e.printStackTrace();
            return null;
        }
    }

    public void deleteBooking(int booking_id) {
        try {
            String hql = "DELETE FROM Booking WHERE booking_id = :booking_id";
            Query query = getSession().createQuery(hql);
            query.setParameter("booking_id", booking_id);
            beginTransaction();
            query.executeUpdate();
            commit();
        } catch (Exception e) {
            rollback();
            System.out.println("Exception in deleteBooking BookingDAO: ");
            e.printStackTrace();
        }
    }
}
