/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtstouch.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mihai
 */
@Stateless
public class UserService {

    @PersistenceContext(unitName = "gtstouchPU")
    EntityManager em;

    public UserService() {
    }

    public int updateLoginTime(String contactEmail, long time) {
        Query q = em.createQuery("update User u set u.lastLoginTime = :loginTime where u.contactEmail = :email");
        q.setParameter("loginTime", time);
        int rez = q.setParameter("email", contactEmail).executeUpdate();
        return rez;

    }

}
