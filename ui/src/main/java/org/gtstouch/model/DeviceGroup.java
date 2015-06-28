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
@Table(name = "DeviceGroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeviceGroup.findAll", query = "SELECT d FROM DeviceGroup d"),
    @NamedQuery(name = "DeviceGroup.findByAccountID", query = "SELECT d FROM DeviceGroup d WHERE d.deviceGroupPK.accountID = :accountID"),
    @NamedQuery(name = "DeviceGroup.findByGroupID", query = "SELECT d FROM DeviceGroup d WHERE d.deviceGroupPK.groupID = :groupID"),
    @NamedQuery(name = "DeviceGroup.findByDisplayName", query = "SELECT d FROM DeviceGroup d WHERE d.displayName = :displayName"),
    @NamedQuery(name = "DeviceGroup.findByDescription", query = "SELECT d FROM DeviceGroup d WHERE d.description = :description"),
    @NamedQuery(name = "DeviceGroup.findByLastUpdateTime", query = "SELECT d FROM DeviceGroup d WHERE d.lastUpdateTime = :lastUpdateTime"),
    @NamedQuery(name = "DeviceGroup.findByCreationTime", query = "SELECT d FROM DeviceGroup d WHERE d.creationTime = :creationTime")})
public class DeviceGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeviceGroupPK deviceGroupPK;
    @Size(max = 40)
    @Column(name = "displayName")
    private String displayName;
    @Size(max = 128)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 65535)
    @Column(name = "notes")
    private String notes;
    @Column(name = "lastUpdateTime")
    private Integer lastUpdateTime;
    @Column(name = "creationTime")
    private Integer creationTime;

    public DeviceGroup() {
    }

    public DeviceGroup(DeviceGroupPK deviceGroupPK) {
        this.deviceGroupPK = deviceGroupPK;
    }

    public DeviceGroup(String accountID, String groupID) {
        this.deviceGroupPK = new DeviceGroupPK(accountID, groupID);
    }

    public DeviceGroupPK getDeviceGroupPK() {
        return deviceGroupPK;
    }

    public void setDeviceGroupPK(DeviceGroupPK deviceGroupPK) {
        this.deviceGroupPK = deviceGroupPK;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Integer lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Integer creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deviceGroupPK != null ? deviceGroupPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeviceGroup)) {
            return false;
        }
        DeviceGroup other = (DeviceGroup) object;
        if ((this.deviceGroupPK == null && other.deviceGroupPK != null) || (this.deviceGroupPK != null && !this.deviceGroupPK.equals(other.deviceGroupPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.DeviceGroup[ deviceGroupPK=" + deviceGroupPK + " ]";
    }
    
}
