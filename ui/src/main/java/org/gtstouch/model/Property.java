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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mihai
 */
@Entity
@Table(name = "Property")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Property.findAll", query = "SELECT p FROM Property p"),
    @NamedQuery(name = "Property.findByAccountID", query = "SELECT p FROM Property p WHERE p.propertyPK.accountID = :accountID"),
    @NamedQuery(name = "Property.findByDeviceID", query = "SELECT p FROM Property p WHERE p.propertyPK.deviceID = :deviceID"),
    @NamedQuery(name = "Property.findByPropKey", query = "SELECT p FROM Property p WHERE p.propertyPK.propKey = :propKey"),
    @NamedQuery(name = "Property.findByTimestamp", query = "SELECT p FROM Property p WHERE p.timestamp = :timestamp")})
public class Property implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PropertyPK propertyPK;
    @Column(name = "timestamp")
    private Integer timestamp;
    @Lob
    @Column(name = "binaryValue")
    private byte[] binaryValue;

    public Property() {
    }

    public Property(PropertyPK propertyPK) {
        this.propertyPK = propertyPK;
    }

    public Property(String accountID, String deviceID, int propKey) {
        this.propertyPK = new PropertyPK(accountID, deviceID, propKey);
    }

    public PropertyPK getPropertyPK() {
        return propertyPK;
    }

    public void setPropertyPK(PropertyPK propertyPK) {
        this.propertyPK = propertyPK;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public byte[] getBinaryValue() {
        return binaryValue;
    }

    public void setBinaryValue(byte[] binaryValue) {
        this.binaryValue = binaryValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propertyPK != null ? propertyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Property)) {
            return false;
        }
        Property other = (Property) object;
        if ((this.propertyPK == null && other.propertyPK != null) || (this.propertyPK != null && !this.propertyPK.equals(other.propertyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.Property[ propertyPK=" + propertyPK + " ]";
    }
    
}
