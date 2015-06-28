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
public class GeozonePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "accountID")
    private String accountID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "geozoneID")
    private String geozoneID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sortID")
    private int sortID;

    public GeozonePK() {
    }

    public GeozonePK(String accountID, String geozoneID, int sortID) {
        this.accountID = accountID;
        this.geozoneID = geozoneID;
        this.sortID = sortID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getGeozoneID() {
        return geozoneID;
    }

    public void setGeozoneID(String geozoneID) {
        this.geozoneID = geozoneID;
    }

    public int getSortID() {
        return sortID;
    }

    public void setSortID(int sortID) {
        this.sortID = sortID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountID != null ? accountID.hashCode() : 0);
        hash += (geozoneID != null ? geozoneID.hashCode() : 0);
        hash += (int) sortID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeozonePK)) {
            return false;
        }
        GeozonePK other = (GeozonePK) object;
        if ((this.accountID == null && other.accountID != null) || (this.accountID != null && !this.accountID.equals(other.accountID))) {
            return false;
        }
        if ((this.geozoneID == null && other.geozoneID != null) || (this.geozoneID != null && !this.geozoneID.equals(other.geozoneID))) {
            return false;
        }
        if (this.sortID != other.sortID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.GeozonePK[ accountID=" + accountID + ", geozoneID=" + geozoneID + ", sortID=" + sortID + " ]";
    }
    
}
