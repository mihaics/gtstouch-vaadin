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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mihai
 */
@Entity
@Table(name = "User")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByAccountID", query = "SELECT u FROM User u WHERE u.userPK.accountID = :accountID"),
    @NamedQuery(name = "User.findByUserID", query = "SELECT u FROM User u WHERE u.userPK.userID = :userID"),
    @NamedQuery(name = "User.findByUserType", query = "SELECT u FROM User u WHERE u.userType = :userType"),
    @NamedQuery(name = "User.findByRoleID", query = "SELECT u FROM User u WHERE u.roleID = :roleID"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByGender", query = "SELECT u FROM User u WHERE u.gender = :gender"),
    @NamedQuery(name = "User.findByNotifyEmail", query = "SELECT u FROM User u WHERE u.notifyEmail = :notifyEmail"),
    @NamedQuery(name = "User.findByContactName", query = "SELECT u FROM User u WHERE u.contactName = :contactName"),
    @NamedQuery(name = "User.findByContactPhone", query = "SELECT u FROM User u WHERE u.contactPhone = :contactPhone"),
    @NamedQuery(name = "User.findByContactEmail", query = "SELECT u FROM User u WHERE u.contactEmail = :contactEmail"),
    @NamedQuery(name = "User.findByTimeZone", query = "SELECT u FROM User u WHERE u.timeZone = :timeZone"),
    @NamedQuery(name = "User.findByFirstLoginPageID", query = "SELECT u FROM User u WHERE u.firstLoginPageID = :firstLoginPageID"),
    @NamedQuery(name = "User.findByPreferredDeviceID", query = "SELECT u FROM User u WHERE u.preferredDeviceID = :preferredDeviceID"),
    @NamedQuery(name = "User.findByMaxAccessLevel", query = "SELECT u FROM User u WHERE u.maxAccessLevel = :maxAccessLevel"),
    @NamedQuery(name = "User.findByPasswdChangeTime", query = "SELECT u FROM User u WHERE u.passwdChangeTime = :passwdChangeTime"),
    @NamedQuery(name = "User.findByPasswdQueryTime", query = "SELECT u FROM User u WHERE u.passwdQueryTime = :passwdQueryTime"),
    @NamedQuery(name = "User.findByLastLoginTime", query = "SELECT u FROM User u WHERE u.lastLoginTime = :lastLoginTime"),
    @NamedQuery(name = "User.findByIsActive", query = "SELECT u FROM User u WHERE u.isActive = :isActive"),
    @NamedQuery(name = "User.findByDisplayName", query = "SELECT u FROM User u WHERE u.displayName = :displayName"),
    @NamedQuery(name = "User.findByDescription", query = "SELECT u FROM User u WHERE u.description = :description"),
    @NamedQuery(name = "User.findByLastUpdateTime", query = "SELECT u FROM User u WHERE u.lastUpdateTime = :lastUpdateTime"),
    @NamedQuery(name = "User.findByCreationTime", query = "SELECT u FROM User u WHERE u.creationTime = :creationTime")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserPK userPK;
    @Column(name = "userType")
    private Short userType;
    @Size(max = 32)
    @Column(name = "roleID")
    private String roleID;
    @Size(max = 32)
    @Column(name = "password")
    private String password;
    @Column(name = "gender")
    private Short gender;
    @Size(max = 128)
    @Column(name = "notifyEmail")
    private String notifyEmail;
    @Size(max = 64)
    @Column(name = "contactName")
    private String contactName;
    @Size(max = 32)
    @Column(name = "contactPhone")
    private String contactPhone;
    @Size(max = 64)
    @Column(name = "contactEmail")
    private String contactEmail;
    @Size(max = 32)
    @Column(name = "timeZone")
    private String timeZone;
    @Size(max = 24)
    @Column(name = "firstLoginPageID")
    private String firstLoginPageID;
    @Size(max = 32)
    @Column(name = "preferredDeviceID")
    private String preferredDeviceID;
    @Column(name = "maxAccessLevel")
    private Short maxAccessLevel;
    @Column(name = "passwdChangeTime")
    private Integer passwdChangeTime;
    @Column(name = "passwdQueryTime")
    private Integer passwdQueryTime;
    @Column(name = "lastLoginTime")
    private Integer lastLoginTime;
    @Column(name = "isActive")
    private Short isActive;
    @Size(max = 40)
    @Column(name = "displayName")
    private String displayName;
    @Size(max = 128)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 65535)
    @Column(name = "notes")
    private String notes;
    @Column(name = "lastUpdateTime")
    private Integer lastUpdateTime;
    @Column(name = "creationTime")
    private Integer creationTime;

    public User() {
    }

    public User(UserPK userPK) {
        this.userPK = userPK;
    }

    public User(String accountID, String userID) {
        this.userPK = new UserPK(accountID, userID);
    }

    public UserPK getUserPK() {
        return userPK;
    }

    public void setUserPK(UserPK userPK) {
        this.userPK = userPK;
    }

    public Short getUserType() {
        return userType;
    }

    public void setUserType(Short userType) {
        this.userType = userType;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getNotifyEmail() {
        return notifyEmail;
    }

    public void setNotifyEmail(String notifyEmail) {
        this.notifyEmail = notifyEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getFirstLoginPageID() {
        return firstLoginPageID;
    }

    public void setFirstLoginPageID(String firstLoginPageID) {
        this.firstLoginPageID = firstLoginPageID;
    }

    public String getPreferredDeviceID() {
        return preferredDeviceID;
    }

    public void setPreferredDeviceID(String preferredDeviceID) {
        this.preferredDeviceID = preferredDeviceID;
    }

    public Short getMaxAccessLevel() {
        return maxAccessLevel;
    }

    public void setMaxAccessLevel(Short maxAccessLevel) {
        this.maxAccessLevel = maxAccessLevel;
    }

    public Integer getPasswdChangeTime() {
        return passwdChangeTime;
    }

    public void setPasswdChangeTime(Integer passwdChangeTime) {
        this.passwdChangeTime = passwdChangeTime;
    }

    public Integer getPasswdQueryTime() {
        return passwdQueryTime;
    }

    public void setPasswdQueryTime(Integer passwdQueryTime) {
        this.passwdQueryTime = passwdQueryTime;
    }

    public Integer getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Integer lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Short getIsActive() {
        return isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
        hash += (userPK != null ? userPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userPK == null && other.userPK != null) || (this.userPK != null && !this.userPK.equals(other.userPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.User[ userPK=" + userPK + " ]";
    }
    
}
