/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtstouch.jpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.gtstouch.model.DevicePK;
import org.gtstouch.model.UserPK;

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

    public UserPK getUserIndex(String contactEmail) {
        Query q = em.createQuery("select DISTINCT u.userPK  from User u where u.contactEmail =:email ", UserPK.class);
        return (UserPK) q.setParameter("email", contactEmail).getSingleResult();

    }

    public List getActiveDevices(UserPK userIndex) {
        Query q = em.createQuery("select DISTINCT d.devicePK from Device d where d.devicePK.accountID =:accountID and d.isActive = 1", DevicePK.class);
        q.setParameter("accountID", userIndex.getAccountID());
        return q.getResultList();
    }

}
