/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtstouch.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mihai
 */
@Stateless
public class AccountService {
    
    @PersistenceContext(unitName = "gtstouchPU")
    EntityManager em;

    public AccountService() {
    }
    
     public int getEntityCount() {
        return em.createQuery("SELECT COUNT(u) FROM Account u", Long.class).
                getSingleResult().intValue();
    }
    
}
