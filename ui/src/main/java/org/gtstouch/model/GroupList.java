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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mihai
 */
@Entity
@Table(name = "GroupList")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupList.findAll", query = "SELECT g FROM GroupList g"),
    @NamedQuery(name = "GroupList.findByAccountID", query = "SELECT g FROM GroupList g WHERE g.groupListPK.accountID = :accountID"),
    @NamedQuery(name = "GroupList.findByUserID", query = "SELECT g FROM GroupList g WHERE g.groupListPK.userID = :userID"),
    @NamedQuery(name = "GroupList.findByGroupID", query = "SELECT g FROM GroupList g WHERE g.groupListPK.groupID = :groupID"),
    @NamedQuery(name = "GroupList.findByCreationTime", query = "SELECT g FROM GroupList g WHERE g.creationTime = :creationTime")})
public class GroupList implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GroupListPK groupListPK;
    @Column(name = "creationTime")
    private Integer creationTime;

    public GroupList() {
    }

    public GroupList(GroupListPK groupListPK) {
        this.groupListPK = groupListPK;
    }

    public GroupList(String accountID, String userID, String groupID) {
        this.groupListPK = new GroupListPK(accountID, userID, groupID);
    }

    public GroupListPK getGroupListPK() {
        return groupListPK;
    }

    public void setGroupListPK(GroupListPK groupListPK) {
        this.groupListPK = groupListPK;
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
        hash += (groupListPK != null ? groupListPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupList)) {
            return false;
        }
        GroupList other = (GroupList) object;
        if ((this.groupListPK == null && other.groupListPK != null) || (this.groupListPK != null && !this.groupListPK.equals(other.groupListPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.GroupList[ groupListPK=" + groupListPK + " ]";
    }
    
}
