/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtstouch.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.gtstouch.model.SystemProps;

/**
 *
 * @author mihai
 */
@Stateless
public class SystemPropsFacade extends AbstractFacade<SystemProps> {
    @PersistenceContext(unitName = "gtstouchPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SystemPropsFacade() {
        super(SystemProps.class);
    }
    
}
