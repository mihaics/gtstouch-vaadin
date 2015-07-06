/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtstouch.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.gtstouch.model.UserAcl;

/**
 *
 * @author mihai
 */
@Stateless
public class UserAclFacade extends AbstractFacade<UserAcl> {
    @PersistenceContext(unitName = "gtstouchPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserAclFacade() {
        super(UserAcl.class);
    }
    
}
