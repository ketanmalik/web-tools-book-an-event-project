/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.pojo.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author ketanmalik
 */
public class UserDao extends DAO {

    public int addUser(String fName, String lName, String email, String password, String city, String state, String country, String user_type) {
        int userAlreadyExists = checkUser(email, user_type);
        if (userAlreadyExists == 0) {
            User user = new User();
            user.setfName(fName);
            user.setlName(lName);
            user.setEmail(email);
            user.setPassword(password);
            user.setCity(city);
            user.setState(state);
            user.setCountry(country);
            user.setUser_type(user_type);
            beginTransaction();
            Serializable res = getSession().save(user);
            commit();
            return 1;
        } else {
            return -1;
        }
    }

    public int checkUser(String email, String user_type) {
        beginTransaction();
        String hql = "FROM User where email=:email and user_type=:user_type";
        Query query = getSession().createQuery(hql);
        query.setParameter("email", email);
        query.setParameter("user_type", user_type);
        List result = query.list();
        commit();
        return result.size();
    }
}
