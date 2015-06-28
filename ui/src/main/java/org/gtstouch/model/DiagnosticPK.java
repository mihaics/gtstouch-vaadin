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
public class DiagnosticPK implements Serializable {
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
    @Column(name = "isError")
    private short isError;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeKey")
    private int codeKey;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timestamp")
    private int timestamp;

    public DiagnosticPK() {
    }

    public DiagnosticPK(String accountID, String deviceID, short isError, int codeKey, int timestamp) {
        this.accountID = accountID;
        this.deviceID = deviceID;
        this.isError = isError;
        this.codeKey = codeKey;
        this.timestamp = timestamp;
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

    public short getIsError() {
        return isError;
    }

    public void setIsError(short isError) {
        this.isError = isError;
    }

    public int getCodeKey() {
        return codeKey;
    }

    public void setCodeKey(int codeKey) {
        this.codeKey = codeKey;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountID != null ? accountID.hashCode() : 0);
        hash += (deviceID != null ? deviceID.hashCode() : 0);
        hash += (int) isError;
        hash += (int) codeKey;
        hash += (int) timestamp;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiagnosticPK)) {
            return false;
        }
        DiagnosticPK other = (DiagnosticPK) object;
        if ((this.accountID == null && other.accountID != null) || (this.accountID != null && !this.accountID.equals(other.accountID))) {
            return false;
        }
        if ((this.deviceID == null && other.deviceID != null) || (this.deviceID != null && !this.deviceID.equals(other.deviceID))) {
            return false;
        }
        if (this.isError != other.isError) {
            return false;
        }
        if (this.codeKey != other.codeKey) {
            return false;
        }
        if (this.timestamp != other.timestamp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.DiagnosticPK[ accountID=" + accountID + ", deviceID=" + deviceID + ", isError=" + isError + ", codeKey=" + codeKey + ", timestamp=" + timestamp + " ]";
    }
    
}
