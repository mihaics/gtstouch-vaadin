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
@Table(name = "UniqueXID")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniqueXID.findAll", query = "SELECT u FROM UniqueXID u"),
    @NamedQuery(name = "UniqueXID.findByUniqueID", query = "SELECT u FROM UniqueXID u WHERE u.uniqueID = :uniqueID"),
    @NamedQuery(name = "UniqueXID.findByAccountID", query = "SELECT u FROM UniqueXID u WHERE u.accountID = :accountID"),
    @NamedQuery(name = "UniqueXID.findByTransportID", query = "SELECT u FROM UniqueXID u WHERE u.transportID = :transportID")})
public class UniqueXID implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "uniqueID")
    private String uniqueID;
    @Size(max = 32)
    @Column(name = "accountID")
    private String accountID;
    @Size(max = 32)
    @Column(name = "transportID")
    private String transportID;

    public UniqueXID() {
    }

    public UniqueXID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getTransportID() {
        return transportID;
    }

    public void setTransportID(String transportID) {
        this.transportID = transportID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uniqueID != null ? uniqueID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UniqueXID)) {
            return false;
        }
        UniqueXID other = (UniqueXID) object;
        if ((this.uniqueID == null && other.uniqueID != null) || (this.uniqueID != null && !this.uniqueID.equals(other.uniqueID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.UniqueXID[ uniqueID=" + uniqueID + " ]";
    }
    
}
