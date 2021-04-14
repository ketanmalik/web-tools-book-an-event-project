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
        List<User> userAlreadyExists = checkUser(email, "", "sign-up");
        if (userAlreadyExists.isEmpty()) {
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

    public List<User> checkUser(String email, String password, String mode) {
        beginTransaction();
        String hql = "";
        if (mode.equalsIgnoreCase("sign-up")) {
            hql = "FROM User where email=:email";
        } else {
            hql = "FROM User where email=:email and password =:password";
        }
        Query query = getSession().createQuery(hql);
        query.setParameter("email", email);
        if (mode.equalsIgnoreCase("log-in")) {
            query.setParameter("password", password);
        }
        List result = query.list();
        commit();
        return result;
    }
}
