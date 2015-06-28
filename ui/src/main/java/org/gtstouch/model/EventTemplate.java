/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtstouch.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mihai
 */
@Entity
@Table(name = "EventTemplate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventTemplate.findAll", query = "SELECT e FROM EventTemplate e"),
    @NamedQuery(name = "EventTemplate.findByAccountID", query = "SELECT e FROM EventTemplate e WHERE e.eventTemplatePK.accountID = :accountID"),
    @NamedQuery(name = "EventTemplate.findByDeviceID", query = "SELECT e FROM EventTemplate e WHERE e.eventTemplatePK.deviceID = :deviceID"),
    @NamedQuery(name = "EventTemplate.findByCustomType", query = "SELECT e FROM EventTemplate e WHERE e.eventTemplatePK.customType = :customType"),
    @NamedQuery(name = "EventTemplate.findByRepeatLast", query = "SELECT e FROM EventTemplate e WHERE e.repeatLast = :repeatLast")})
public class EventTemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EventTemplatePK eventTemplatePK;
    @Column(name = "repeatLast")
    private Short repeatLast;
    @Lob
    @Size(max = 65535)
    @Column(name = "template")
    private String template;

    public EventTemplate() {
    }

    public EventTemplate(EventTemplatePK eventTemplatePK) {
        this.eventTemplatePK = eventTemplatePK;
    }

    public EventTemplate(String accountID, String deviceID, short customType) {
        this.eventTemplatePK = new EventTemplatePK(accountID, deviceID, customType);
    }

    public EventTemplatePK getEventTemplatePK() {
        return eventTemplatePK;
    }

    public void setEventTemplatePK(EventTemplatePK eventTemplatePK) {
        this.eventTemplatePK = eventTemplatePK;
    }

    public Short getRepeatLast() {
        return repeatLast;
    }

    public void setRepeatLast(Short repeatLast) {
        this.repeatLast = repeatLast;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventTemplatePK != null ? eventTemplatePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventTemplate)) {
            return false;
        }
        EventTemplate other = (EventTemplate) object;
        if ((this.eventTemplatePK == null && other.eventTemplatePK != null) || (this.eventTemplatePK != null && !this.eventTemplatePK.equals(other.eventTemplatePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.EventTemplate[ eventTemplatePK=" + eventTemplatePK + " ]";
    }
    
}
