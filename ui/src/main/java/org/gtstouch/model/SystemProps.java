/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gtstouch.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mihai
 */
@Entity
@Table(name = "SystemProps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemProps.findAll", query = "SELECT s FROM SystemProps s"),
    @NamedQuery(name = "SystemProps.findByPropertyID", query = "SELECT s FROM SystemProps s WHERE s.propertyID = :propertyID"),
    @NamedQuery(name = "SystemProps.findByDataType", query = "SELECT s FROM SystemProps s WHERE s.dataType = :dataType"),
    @NamedQuery(name = "SystemProps.findByDescription", query = "SELECT s FROM SystemProps s WHERE s.description = :description"),
    @NamedQuery(name = "SystemProps.findByLastUpdateTime", query = "SELECT s FROM SystemProps s WHERE s.lastUpdateTime = :lastUpdateTime"),
    @NamedQuery(name = "SystemProps.findByCreationTime", query = "SELECT s FROM SystemProps s WHERE s.creationTime = :creationTime")})
public class SystemProps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "propertyID")
    private String propertyID;
    @Size(max = 80)
    @Column(name = "dataType")
    private String dataType;
    @Lob
    @Size(max = 65535)
    @Column(name = "value")
    private String value;
    @Size(max = 128)
    @Column(name = "description")
    private String description;
    @Column(name = "lastUpdateTime")
    private Integer lastUpdateTime;
    @Column(name = "creationTime")
    private Integer creationTime;

    public SystemProps() {
    }

    public SystemProps(String propertyID) {
        this.propertyID = propertyID;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (propertyID != null ? propertyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SystemProps)) {
            return false;
        }
        SystemProps other = (SystemProps) object;
        if ((this.propertyID == null && other.propertyID != null) || (this.propertyID != null && !this.propertyID.equals(other.propertyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.SystemProps[ propertyID=" + propertyID + " ]";
    }
    
}
