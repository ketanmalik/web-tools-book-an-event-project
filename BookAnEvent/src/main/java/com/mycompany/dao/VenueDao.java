/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import java.util.List;
import org.hibernate.query.Query;
import com.mycompany.pojo.Venue;
import java.util.ArrayList;

/**
 *
 * @author ketanmalik
 */
public class VenueDao extends DAO {

    public int deleteVenue(int venue_id) {
        beginTransaction();
        String hql = "DELETE FROM Venue WHERE venue_id=:venue_id";
        Query query = getSession().createQuery(hql);
        query.setParameter("venue_id", venue_id);
        int res = query.executeUpdate();
        commit();
        return res;
    }

    public Venue getVenue(int venue_id) {
        try {
            beginTransaction();
            String hql = "FROM Venue WHERE venue_id=:venue_id";
            Query query = getSession().createQuery(hql);
            query.setParameter("venue_id", venue_id);
            List<Venue> eventList = new ArrayList<>();
            eventList = query.list();
            if (eventList.isEmpty()) {
                return null;
            }
            commit();
            return eventList.get(0);
        } catch (Exception e) {
            rollback();
            System.out.println("Exception in getVenue: " + e);
            return null;
        }

    }

    public List<Venue> getVenueList() {
        try {
            beginTransaction();
            String hql = "FROM Venue";
            Query query = getSession().createQuery(hql);
            List result = new ArrayList<>();
            result = query.list();
            commit();
            return result;
        } catch (Exception e) {
            rollback();
            System.out.println("Exception in getVenueList: " + e);
            return null;
        }
    }

    public int saveVenue(Venue venue) {
        try {
            beginTransaction();
            getSession().save(venue);
            commit();
            return 1;
        } catch (Exception e) {
            rollback();
            System.out.println("Exception in saveVenue: ");
            e.printStackTrace();
            return 0;
        }
    }

    public int updateVenue(int venue_id, Venue venue) {
        try {
            String venue_name = venue.getVenue_name();
            String venue_city = venue.getVenue_city();
            String venue_state = venue.getVenue_state();
            String venue_country = venue.getVenue_country();
            String hql = "UPDATE Venue SET venue_name=:venue_name, venue_city=:venue_city, venue_state=:venue_state, "
                    + "venue_country=:venue_country WHERE venue_id=:venue_id";
            Query query = getSession().createQuery(hql);
            query.setParameter("venue_id", venue_id);
            query.setParameter("venue_name", venue_name);
            query.setParameter("venue_city", venue_city);
            query.setParameter("venue_state", venue_state);
            query.setParameter("venue_country", venue_country);
            beginTransaction();
            int res = query.executeUpdate();
            commit();
            return res;
        } catch (Exception e) {
            System.out.println("Exception in updateVenue: " + e);
            return 0;
        }
    }
}
