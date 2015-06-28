/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtstouch.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mihai
 */
@Embeddable
public class PropertyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "accountID")
    private String accountID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "deviceID")
    private String deviceID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "propKey")
    private int propKey;

    public PropertyPK() {
    }

    public PropertyPK(String accountID, String deviceID, int propKey) {
        this.accountID = accountID;
        this.deviceID = deviceID;
        this.propKey = propKey;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public int getPropKey() {
        return propKey;
    }

    public void setPropKey(int propKey) {
        this.propKey = propKey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountID != null ? accountID.hashCode() : 0);
        hash += (deviceID != null ? deviceID.hashCode() : 0);
        hash += (int) propKey;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PropertyPK)) {
            return false;
        }
        PropertyPK other = (PropertyPK) object;
        if ((this.accountID == null && other.accountID != null) || (this.accountID != null && !this.accountID.equals(other.accountID))) {
            return false;
        }
        if ((this.deviceID == null && other.deviceID != null) || (this.deviceID != null && !this.deviceID.equals(other.deviceID))) {
            return false;
        }
        if (this.propKey != other.propKey) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.PropertyPK[ accountID=" + accountID + ", deviceID=" + deviceID + ", propKey=" + propKey + " ]";
    }
    
}
