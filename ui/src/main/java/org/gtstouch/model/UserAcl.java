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
@Table(name = "UserAcl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAcl.findAll", query = "SELECT u FROM UserAcl u"),
    @NamedQuery(name = "UserAcl.findByAccountID", query = "SELECT u FROM UserAcl u WHERE u.userAclPK.accountID = :accountID"),
    @NamedQuery(name = "UserAcl.findByUserID", query = "SELECT u FROM UserAcl u WHERE u.userAclPK.userID = :userID"),
    @NamedQuery(name = "UserAcl.findByAclID", query = "SELECT u FROM UserAcl u WHERE u.userAclPK.aclID = :aclID"),
    @NamedQuery(name = "UserAcl.findByAccessLevel", query = "SELECT u FROM UserAcl u WHERE u.accessLevel = :accessLevel"),
    @NamedQuery(name = "UserAcl.findByDescription", query = "SELECT u FROM UserAcl u WHERE u.description = :description"),
    @NamedQuery(name = "UserAcl.findByLastUpdateTime", query = "SELECT u FROM UserAcl u WHERE u.lastUpdateTime = :lastUpdateTime"),
    @NamedQuery(name = "UserAcl.findByCreationTime", query = "SELECT u FROM UserAcl u WHERE u.creationTime = :creationTime")})
public class UserAcl implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserAclPK userAclPK;
    @Column(name = "accessLevel")
    private Short accessLevel;
    @Size(max = 128)
    @Column(name = "description")
    private String description;
    @Column(name = "lastUpdateTime")
    private Integer lastUpdateTime;
    @Column(name = "creationTime")
    private Integer creationTime;

    public UserAcl() {
    }

    public UserAcl(UserAclPK userAclPK) {
        this.userAclPK = userAclPK;
    }

    public UserAcl(String accountID, String userID, String aclID) {
        this.userAclPK = new UserAclPK(accountID, userID, aclID);
    }

    public UserAclPK getUserAclPK() {
        return userAclPK;
    }

    public void setUserAclPK(UserAclPK userAclPK) {
        this.userAclPK = userAclPK;
    }

    public Short getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(Short accessLevel) {
        this.accessLevel = accessLevel;
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
        hash += (userAclPK != null ? userAclPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAcl)) {
            return false;
        }
        UserAcl other = (UserAcl) object;
        if ((this.userAclPK == null && other.userAclPK != null) || (this.userAclPK != null && !this.userAclPK.equals(other.userAclPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.UserAcl[ userAclPK=" + userAclPK + " ]";
    }
    
}
