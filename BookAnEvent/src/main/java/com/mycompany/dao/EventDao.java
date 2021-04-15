/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import static com.mycompany.dao.DAO.getSession;
import com.mycompany.pojo.Event;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author ketanmalik
 */
public class EventDao extends DAO {

    public int saveEvent(String event_name, String event_type, String event_cast, String event_rating, String event_genre,
            String event_language, String event_summary, int event_duration, Date event_date) {

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
        Serializable res = getSession().save(event);
        commit();
        return 1;
    }

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
        beginTransaction();
        String hql = "FROM Event WHERE event_id=:event_id";
        Query query = getSession().createQuery(hql);
        query.setParameter("event_id", event_id);
        List<Event> eventList = query.list();
        if (eventList.isEmpty()) {
            return null;
        }
        commit();
        return eventList.get(0);
    }

    public List<Event> getEventList() {
        beginTransaction();
        String hql = "FROM Event";
        Query query = getSession().createQuery(hql);
        List result = query.list();
        commit();
        return result;
    }
}
