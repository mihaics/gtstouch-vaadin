/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtstouch.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.gtstouch.model.EventData;

/**
 *
 * @author mihai
 */
@Stateless
public class EventDataFacade extends AbstractFacade<EventData> {

    @PersistenceContext(unitName = "gtstouchPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventDataFacade() {
        super(EventData.class);
    }

    public List<EventData> findByAccountID(String accountID) {

        javax.persistence.Query q = getEntityManager().createNamedQuery("EventData.findByAccountID");
        q.setParameter("accountID", accountID);
        return q.getResultList();
    }

    public List<EventData> findByDeviceID(String deviceID) {

        javax.persistence.Query q = getEntityManager().createNamedQuery("EventData.findByDeviceID");
        q.setParameter("deviceID", deviceID);
        return q.getResultList();
    }

    public List<EventData> findByTimestamp(int timestamp) {

        javax.persistence.Query q = getEntityManager().createNamedQuery("EventData.findByTimestamp");
        q.setParameter("timestamp", timestamp);
        return q.getResultList();
    }

    public List<EventData> findByAddress(String address) {

        javax.persistence.Query q = getEntityManager().createNamedQuery("EventData.findByAddress");
        q.setParameter("address", address);
        return q.getResultList();
    }
}
