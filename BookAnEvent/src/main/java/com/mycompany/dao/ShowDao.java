/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.pojo.Event;
import com.mycompany.pojo.Show;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author ketanmalik
 */
public class ShowDao extends DAO {

    public int addShow(Show show) {
        try {
            beginTransaction();
            getSession().save(show);
            commit();
            return 1;
        } catch (Exception e) {
            rollback();
            System.out.println("Exception in addShow DAO: ");
            e.printStackTrace();
            return 0;
        }
    }

    public List<Show> getShowList() {
        try {
            String hql = "FROM Show";
            Query query = getSession().createQuery(hql);
            List result = new ArrayList<>();
            beginTransaction();
            result = query.list();
            commit();
            return result;
        } catch (Exception e) {
            rollback();
            System.out.println("Exception in getShowList Dao: ");
            e.printStackTrace();
            return null;
        }
    }

    public List<Event> getEventsInCity(String city) {
        try {
            String hql = "SELECT DISTINCT event FROM Show WHERE venue_id in (SELECT venue_id FROM Venue WHERE venue_city = :city)";
            Query query = getSession().createQuery(hql);
            query.setParameter("city", city);
            beginTransaction();
            List<Event> eventsList = query.list();
            commit();
            return eventsList;
        } catch (Exception e) {
            rollback();
            System.out.println("Exception in getEventsFromCity Dao: ");
            e.printStackTrace();
            return null;
        }
    }

    public List<Show> getShow(String city, String event) {
        try {
            beginTransaction();

            String event_hql = "SELECT event_id FROM Event WHERE event_name = :event_name";
            Query event_query = getSession().createQuery(event_hql);
            event_query.setParameter("event_name", event);

            List<Integer> event_id_list = event_query.list();
            if (event_id_list.isEmpty()) {
                rollback();
                return null;
            }
            int event_id = (Integer) event_query.list().get(0);

            String venue_hql = "SELECT venue_id FROM Venue WHERE venue_city = :venue_city";
            Query venue_query = getSession().createQuery(venue_hql);
            venue_query.setParameter("venue_city", city);
            List<Integer> venue_id_list = venue_query.list();
            if (venue_id_list.isEmpty()) {
                rollback();
                return null;
            }

            String shows_hql = "FROM Show WHERE event.event_id = :event_id AND venue.venue_id IN (:venue_ids)";
            Query shows_query = getSession().createQuery(shows_hql);
            shows_query.setParameter("event_id", event_id);
            shows_query.setParameterList("venue_ids", venue_id_list);
            List<Show> shows = shows_query.list();
            if (shows.isEmpty()) {
                rollback();
                return null;
            }
            commit();
            return shows;
        } catch (Exception e) {
            rollback();
            System.out.println("Exception in getShowList Dao: ");
            e.printStackTrace();
            return null;
        }
    }

    public Show getShowObj(int show_id) {
        try {
            String hql = "FROM Show WHERE show_id = :show_id";
            Query query = getSession().createQuery(hql);
            query.setParameter("show_id", show_id);
            beginTransaction();
            List<Show> shows = query.list();
            if (shows.isEmpty()) {
                rollback();
                return null;
            }
            commit();
            return shows.get(0);
        } catch (Exception e) {
            rollback();
            System.out.println("Exception in getShowList Dao: ");
            e.printStackTrace();
            return null;
        }
    }

    public Show updateSeatsLeft(int show_id, int seats_booked) {
        try {
            String hql = "FROM Show WHERE show_id = :show_id";
            Query query = getSession().createQuery(hql);
            query.setParameter("show_id", show_id);
            beginTransaction();
            List<Show> shows = query.list();
            if (shows.isEmpty()) {
                rollback();
                return null;
            }
            Show show_to_update = shows.get(0);
            int seats_left = show_to_update.getSeats_left() - seats_booked;
            if (seats_left < 0) {
                rollback();
                return null;
            }
            hql = "UPDATE Show SET seats_left = :seats_left where show_id = :show_id";
            query = getSession().createQuery(hql);
            query.setParameter("seats_left", seats_left);
            query.setParameter("show_id", show_id);
            query.executeUpdate();
            commit();
            show_to_update.setSeats_left(seats_left);
            return show_to_update;
        } catch (Exception e) {
            rollback();
            System.out.println("Exception in updateSeatsLeft ShowDao: ");
            e.printStackTrace();
            return null;
        }
    }

    public void addSeats(int show_id, int seatsToAdd) {
        try {
            String hql = "FROM Show WHERE show_id = :show_id";
            Query query = getSession().createQuery(hql);
            query.setParameter("show_id", show_id);
            beginTransaction();
            List<Show> shows = query.list();
            if (shows.isEmpty()) {
                rollback();
            }
            Show show = shows.get(0);
            show.setSeats_left(show.getSeats_left() + seatsToAdd);
            getSession().update(show);
            commit();
        } catch (Exception e) {
            rollback();
            System.out.println("Exception in getShowList Dao: ");
            e.printStackTrace();
        }
    }
}
