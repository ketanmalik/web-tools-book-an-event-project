/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author ketanmalik
 */
public class DAO {

    private static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private Session session = null;

    protected DAO() {
    }

    public Session getSession() {
        if (session == null || !session.isOpen()) {
            session = sessionFactory.openSession();
        };
        return session;
    }

    public void beginTransaction() {
        getSession().beginTransaction();
    }

    public void commit() {
        getSession().getTransaction().commit();
    }

    public void close() {
        getSession().close();
    }

    public void rollback() {
        getSession().getTransaction().rollback(); //rollback transactiongetSession().close(); //close sessionDAO.session.set(null); //remove session from thread local}public static void close() {getSession().close(); //close sessionDAO.session.set(null); //remove session from thread local}
    }
}
