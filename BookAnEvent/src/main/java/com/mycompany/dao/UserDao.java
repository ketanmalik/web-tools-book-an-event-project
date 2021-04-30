/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.pojo.User;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author ketanmalik
 */
public class UserDao extends DAO {

    public int addUser(String fName, String lName, String email, String password, String city, String state, String country, String user_type) {
        boolean userAlreadyExists = checkUser(email, "", "sign-up");
        if (userAlreadyExists) {
            return -1;
        }
        try {
            User user = new User(fName, lName, email, password, city, state, country, user_type);
            beginTransaction();
            getSession().save(user);
            commit();
            return 1;
        } catch (Exception e) {
            rollback();
            System.out.println("Exception in addUser UserDao: ");
            e.printStackTrace();
            return -1;
        }
    }

    public boolean checkUser(String email, String password, String mode) {
        String hql;
        if (mode.equalsIgnoreCase("sign-up")) {
            hql = "FROM User where email=:email";
        } else {
            hql = "FROM User where email=:email and password =:password";
        }
        try {
            Query query = getSession().createQuery(hql);
            query.setParameter("email", email);
            if (mode.equalsIgnoreCase("log-in")) {
                query.setParameter("password", password);
            }
            beginTransaction();
            List users = query.list();
            if (users.isEmpty()) {
                rollback();
                return false;
            }
            commit();
            return true;
        } catch (Exception e) {
            rollback();
            System.out.println("Exception in checkUser UserDao: ");
            e.printStackTrace();
            return false;
        }
    }

    public User getUser(String email) {
        try {
            String hql = "From User Where email = :email";
            Query query = getSession().createQuery(hql);
            query.setParameter("email", email);
            beginTransaction();
            List<User> users = query.list();
            if (users.isEmpty()) {
                rollback();
                return null;
            }
            commit();
            return users.get(0);
        } catch (Exception e) {
            rollback();
            System.out.println("Exception in getUser UserDao: ");
            e.printStackTrace();
            return null;
        }
    }
}
