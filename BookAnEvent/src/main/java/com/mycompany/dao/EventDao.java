/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import static com.mycompany.dao.DAO.getSession;
import com.mycompany.pojo.Event;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author ketanmalik
 */
public class EventDao extends DAO {

    public int deleteEvent(int event_id) {
        beginTransaction();
        String hql = "DELETE FROM Event WHERE event_id=:event_id";
        Query query = getSession().createQuery(hql);
        query.setParameter("event_id", event_id);
        int res = query.executeUpdate();
        commit();
        return res;
    }

    public Event getEvent(int event_id) {
        try {
            beginTransaction();
            String hql = "FROM Event WHERE event_id=:event_id";
            Query query = getSession().createQuery(hql);
            query.setParameter("event_id", event_id);
            List<Event> eventList = new ArrayList<>();
            eventList = query.list();
            if (eventList.isEmpty()) {
                return null;
            }
            commit();
            return eventList.get(0);
        } catch (Exception e) {
            rollback();
            System.out.println("Exception in getEvent: " + e);
            return null;
        }
    }

    public List<Event> getEventList() {
        try {
            beginTransaction();
            String hql = "FROM Event";
            Query query = getSession().createQuery(hql);
            List<Event> result = new ArrayList<>();
            result = query.list();
            commit();
//            System.out.println("-----------------------------");
//            for(int i=0; i<result.size(); i++) {
//                System.out.println("event id: " + result.get(i).getEvent_id());
//                System.out.println("event name: " + result.get(i).getEvent_name());
//            }
//            System.out.println("-----------------------------");
            return result;
        } catch (Exception e) {
            System.out.println("Exception in getEventList: " + e);
            rollback();
            return null;
        }

    }

    public int saveEvent(String event_name, String event_type, String event_cast, String event_rating, String event_genre,
            String event_language, String event_summary, String event_duration, Date event_date) {

        Event event = new Event();
        event.setEvent_name(event_name);
        event.setEvent_type(event_type);
        event.setEvent_cast(event_cast);
        event.setEvent_rating(event_rating);
        event.setEvent_genre(event_genre);
        event.setEvent_language(event_language);
        event.setEvent_summary(event_summary);
        event.setEvent_duration(event_duration);
        event.setEvent_date(event_date);
        beginTransaction();
        getSession().save(event);
        commit();
        return 1;
    }

    public int updateEvent(int event_id, Event event) {
        String event_name = event.getEvent_name();
        String event_cast = event.getEvent_cast();
        String event_type = event.getEvent_type();
        String event_rating = event.getEvent_rating();
        String event_genre = event.getEvent_genre();
        String event_language = event.getEvent_language();
        String event_summary = event.getEvent_summary();
        Date event_date = event.getEvent_date();
        String event_duration = event.getEvent_duration();
        String hql = "UPDATE Event SET event_name=:event_name, event_cast=:event_cast, event_type=:event_type, "
                + "event_rating=:event_rating, event_genre=:event_genre, event_language=:event_language, "
                + "event_summary=:event_summary, event_date=:event_date, event_duration=:event_duration WHERE event_id=:event_id";
        Query query = getSession().createQuery(hql);
        query.setParameter("event_id", event_id);
        query.setParameter("event_name", event_name);
        query.setParameter("event_cast", event_cast);
        query.setParameter("event_type", event_type);
        query.setParameter("event_rating", event_rating);
        query.setParameter("event_genre", event_genre);
        query.setParameter("event_language", event_language);
        query.setParameter("event_summary", event_summary);
        query.setParameter("event_date", event_date);
        query.setParameter("event_duration", event_duration);
        beginTransaction();
        int res = query.executeUpdate();
        commit();
        return res;
    }
}
