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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mihai
 */
@Entity
@Table(name = "DeviceList")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeviceList.findAll", query = "SELECT d FROM DeviceList d"),
    @NamedQuery(name = "DeviceList.findByAccountID", query = "SELECT d FROM DeviceList d WHERE d.deviceListPK.accountID = :accountID"),
    @NamedQuery(name = "DeviceList.findByGroupID", query = "SELECT d FROM DeviceList d WHERE d.deviceListPK.groupID = :groupID"),
    @NamedQuery(name = "DeviceList.findByDeviceID", query = "SELECT d FROM DeviceList d WHERE d.deviceListPK.deviceID = :deviceID"),
    @NamedQuery(name = "DeviceList.findByLastUpdateTime", query = "SELECT d FROM DeviceList d WHERE d.lastUpdateTime = :lastUpdateTime"),
    @NamedQuery(name = "DeviceList.findByCreationTime", query = "SELECT d FROM DeviceList d WHERE d.creationTime = :creationTime")})
public class DeviceList implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeviceListPK deviceListPK;
    @Column(name = "lastUpdateTime")
    private Integer lastUpdateTime;
    @Column(name = "creationTime")
    private Integer creationTime;

    public DeviceList() {
    }

    public DeviceList(DeviceListPK deviceListPK) {
        this.deviceListPK = deviceListPK;
    }

    public DeviceList(String accountID, String groupID, String deviceID) {
        this.deviceListPK = new DeviceListPK(accountID, groupID, deviceID);
    }

    public DeviceListPK getDeviceListPK() {
        return deviceListPK;
    }

    public void setDeviceListPK(DeviceListPK deviceListPK) {
        this.deviceListPK = deviceListPK;
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
        hash += (deviceListPK != null ? deviceListPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeviceList)) {
            return false;
        }
        DeviceList other = (DeviceList) object;
        if ((this.deviceListPK == null && other.deviceListPK != null) || (this.deviceListPK != null && !this.deviceListPK.equals(other.deviceListPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.DeviceList[ deviceListPK=" + deviceListPK + " ]";
    }
    
}
