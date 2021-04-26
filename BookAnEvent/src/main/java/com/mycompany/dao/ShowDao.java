/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.pojo.Show;

/**
 *
 * @author ketanmalik
 */
public class ShowDao extends DAO {

    public int addShow(Show show) {
        try {
            System.out.println("event id: " + show.getEvent());
            System.out.println("venue id: " + show.getVenue());
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
}
