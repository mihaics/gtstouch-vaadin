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
@Table(name = "Diagnostic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostic.findAll", query = "SELECT d FROM Diagnostic d"),
    @NamedQuery(name = "Diagnostic.findByAccountID", query = "SELECT d FROM Diagnostic d WHERE d.diagnosticPK.accountID = :accountID"),
    @NamedQuery(name = "Diagnostic.findByDeviceID", query = "SELECT d FROM Diagnostic d WHERE d.diagnosticPK.deviceID = :deviceID"),
    @NamedQuery(name = "Diagnostic.findByIsError", query = "SELECT d FROM Diagnostic d WHERE d.diagnosticPK.isError = :isError"),
    @NamedQuery(name = "Diagnostic.findByCodeKey", query = "SELECT d FROM Diagnostic d WHERE d.diagnosticPK.codeKey = :codeKey"),
    @NamedQuery(name = "Diagnostic.findByTimestamp", query = "SELECT d FROM Diagnostic d WHERE d.diagnosticPK.timestamp = :timestamp")})
public class Diagnostic implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiagnosticPK diagnosticPK;
    @Lob
    @Column(name = "binaryValue")
    private byte[] binaryValue;

    public Diagnostic() {
    }

    public Diagnostic(DiagnosticPK diagnosticPK) {
        this.diagnosticPK = diagnosticPK;
    }

    public Diagnostic(String accountID, String deviceID, short isError, int codeKey, int timestamp) {
        this.diagnosticPK = new DiagnosticPK(accountID, deviceID, isError, codeKey, timestamp);
    }

    public DiagnosticPK getDiagnosticPK() {
        return diagnosticPK;
    }

    public void setDiagnosticPK(DiagnosticPK diagnosticPK) {
        this.diagnosticPK = diagnosticPK;
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
        hash += (diagnosticPK != null ? diagnosticPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostic)) {
            return false;
        }
        Diagnostic other = (Diagnostic) object;
        if ((this.diagnosticPK == null && other.diagnosticPK != null) || (this.diagnosticPK != null && !this.diagnosticPK.equals(other.diagnosticPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.Diagnostic[ diagnosticPK=" + diagnosticPK + " ]";
    }
    
}
