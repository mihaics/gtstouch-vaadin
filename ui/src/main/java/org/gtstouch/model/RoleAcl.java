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
@Table(name = "RoleAcl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoleAcl.findAll", query = "SELECT r FROM RoleAcl r"),
    @NamedQuery(name = "RoleAcl.findByAccountID", query = "SELECT r FROM RoleAcl r WHERE r.roleAclPK.accountID = :accountID"),
    @NamedQuery(name = "RoleAcl.findByRoleID", query = "SELECT r FROM RoleAcl r WHERE r.roleAclPK.roleID = :roleID"),
    @NamedQuery(name = "RoleAcl.findByAclID", query = "SELECT r FROM RoleAcl r WHERE r.roleAclPK.aclID = :aclID"),
    @NamedQuery(name = "RoleAcl.findByAccessLevel", query = "SELECT r FROM RoleAcl r WHERE r.accessLevel = :accessLevel"),
    @NamedQuery(name = "RoleAcl.findByDescription", query = "SELECT r FROM RoleAcl r WHERE r.description = :description"),
    @NamedQuery(name = "RoleAcl.findByLastUpdateTime", query = "SELECT r FROM RoleAcl r WHERE r.lastUpdateTime = :lastUpdateTime"),
    @NamedQuery(name = "RoleAcl.findByCreationTime", query = "SELECT r FROM RoleAcl r WHERE r.creationTime = :creationTime")})
public class RoleAcl implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoleAclPK roleAclPK;
    @Column(name = "accessLevel")
    private Short accessLevel;
    @Size(max = 128)
    @Column(name = "description")
    private String description;
    @Column(name = "lastUpdateTime")
    private Integer lastUpdateTime;
    @Column(name = "creationTime")
    private Integer creationTime;

    public RoleAcl() {
    }

    public RoleAcl(RoleAclPK roleAclPK) {
        this.roleAclPK = roleAclPK;
    }

    public RoleAcl(String accountID, String roleID, String aclID) {
        this.roleAclPK = new RoleAclPK(accountID, roleID, aclID);
    }

    public RoleAclPK getRoleAclPK() {
        return roleAclPK;
    }

    public void setRoleAclPK(RoleAclPK roleAclPK) {
        this.roleAclPK = roleAclPK;
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
        hash += (roleAclPK != null ? roleAclPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleAcl)) {
            return false;
        }
        RoleAcl other = (RoleAcl) object;
        if ((this.roleAclPK == null && other.roleAclPK != null) || (this.roleAclPK != null && !this.roleAclPK.equals(other.roleAclPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.RoleAcl[ roleAclPK=" + roleAclPK + " ]";
    }
    
}
