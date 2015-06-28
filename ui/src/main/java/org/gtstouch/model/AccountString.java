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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mihai
 */
@Entity
@Table(name = "AccountString")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountString.findAll", query = "SELECT a FROM AccountString a"),
    @NamedQuery(name = "AccountString.findByAccountID", query = "SELECT a FROM AccountString a WHERE a.accountStringPK.accountID = :accountID"),
    @NamedQuery(name = "AccountString.findByStringID", query = "SELECT a FROM AccountString a WHERE a.accountStringPK.stringID = :stringID"),
    @NamedQuery(name = "AccountString.findBySingularTitle", query = "SELECT a FROM AccountString a WHERE a.singularTitle = :singularTitle"),
    @NamedQuery(name = "AccountString.findByPluralTitle", query = "SELECT a FROM AccountString a WHERE a.pluralTitle = :pluralTitle"),
    @NamedQuery(name = "AccountString.findByDescription", query = "SELECT a FROM AccountString a WHERE a.description = :description"),
    @NamedQuery(name = "AccountString.findByLastUpdateTime", query = "SELECT a FROM AccountString a WHERE a.lastUpdateTime = :lastUpdateTime"),
    @NamedQuery(name = "AccountString.findByCreationTime", query = "SELECT a FROM AccountString a WHERE a.creationTime = :creationTime")})
public class AccountString implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccountStringPK accountStringPK;
    @Size(max = 64)
    @Column(name = "singularTitle")
    private String singularTitle;
    @Size(max = 64)
    @Column(name = "pluralTitle")
    private String pluralTitle;
    @Size(max = 128)
    @Column(name = "description")
    private String description;
    @Column(name = "lastUpdateTime")
    private Integer lastUpdateTime;
    @Column(name = "creationTime")
    private Integer creationTime;

    public AccountString() {
    }

    public AccountString(AccountStringPK accountStringPK) {
        this.accountStringPK = accountStringPK;
    }

    public AccountString(String accountID, String stringID) {
        this.accountStringPK = new AccountStringPK(accountID, stringID);
    }

    public AccountStringPK getAccountStringPK() {
        return accountStringPK;
    }

    public void setAccountStringPK(AccountStringPK accountStringPK) {
        this.accountStringPK = accountStringPK;
    }

    public String getSingularTitle() {
        return singularTitle;
    }

    public void setSingularTitle(String singularTitle) {
        this.singularTitle = singularTitle;
    }

    public String getPluralTitle() {
        return pluralTitle;
    }

    public void setPluralTitle(String pluralTitle) {
        this.pluralTitle = pluralTitle;
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
        hash += (accountStringPK != null ? accountStringPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountString)) {
            return false;
        }
        AccountString other = (AccountString) object;
        if ((this.accountStringPK == null && other.accountStringPK != null) || (this.accountStringPK != null && !this.accountStringPK.equals(other.accountStringPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.AccountString[ accountStringPK=" + accountStringPK + " ]";
    }
    
}
