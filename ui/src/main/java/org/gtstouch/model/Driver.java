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
@Table(name = "Driver")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Driver.findAll", query = "SELECT d FROM Driver d"),
    @NamedQuery(name = "Driver.findByAccountID", query = "SELECT d FROM Driver d WHERE d.driverPK.accountID = :accountID"),
    @NamedQuery(name = "Driver.findByDriverID", query = "SELECT d FROM Driver d WHERE d.driverPK.driverID = :driverID"),
    @NamedQuery(name = "Driver.findByContactPhone", query = "SELECT d FROM Driver d WHERE d.contactPhone = :contactPhone"),
    @NamedQuery(name = "Driver.findByContactEmail", query = "SELECT d FROM Driver d WHERE d.contactEmail = :contactEmail"),
    @NamedQuery(name = "Driver.findByLicenseType", query = "SELECT d FROM Driver d WHERE d.licenseType = :licenseType"),
    @NamedQuery(name = "Driver.findByLicenseNumber", query = "SELECT d FROM Driver d WHERE d.licenseNumber = :licenseNumber"),
    @NamedQuery(name = "Driver.findByLicenseExpire", query = "SELECT d FROM Driver d WHERE d.licenseExpire = :licenseExpire"),
    @NamedQuery(name = "Driver.findByBadgeID", query = "SELECT d FROM Driver d WHERE d.badgeID = :badgeID"),
    @NamedQuery(name = "Driver.findByAddress", query = "SELECT d FROM Driver d WHERE d.address = :address"),
    @NamedQuery(name = "Driver.findByBirthdate", query = "SELECT d FROM Driver d WHERE d.birthdate = :birthdate"),
    @NamedQuery(name = "Driver.findByDeviceID", query = "SELECT d FROM Driver d WHERE d.deviceID = :deviceID"),
    @NamedQuery(name = "Driver.findByDriverStatus", query = "SELECT d FROM Driver d WHERE d.driverStatus = :driverStatus"),
    @NamedQuery(name = "Driver.findByDutyStatus", query = "SELECT d FROM Driver d WHERE d.dutyStatus = :dutyStatus"),
    @NamedQuery(name = "Driver.findByDisplayName", query = "SELECT d FROM Driver d WHERE d.displayName = :displayName"),
    @NamedQuery(name = "Driver.findByDescription", query = "SELECT d FROM Driver d WHERE d.description = :description"),
    @NamedQuery(name = "Driver.findByLastUpdateTime", query = "SELECT d FROM Driver d WHERE d.lastUpdateTime = :lastUpdateTime"),
    @NamedQuery(name = "Driver.findByCreationTime", query = "SELECT d FROM Driver d WHERE d.creationTime = :creationTime")})
public class Driver implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DriverPK driverPK;
    @Size(max = 32)
    @Column(name = "contactPhone")
    private String contactPhone;
    @Size(max = 128)
    @Column(name = "contactEmail")
    private String contactEmail;
    @Size(max = 24)
    @Column(name = "licenseType")
    private String licenseType;
    @Size(max = 32)
    @Column(name = "licenseNumber")
    private String licenseNumber;
    @Column(name = "licenseExpire")
    private Integer licenseExpire;
    @Size(max = 32)
    @Column(name = "badgeID")
    private String badgeID;
    @Size(max = 90)
    @Column(name = "address")
    private String address;
    @Column(name = "birthdate")
    private Integer birthdate;
    @Size(max = 32)
    @Column(name = "deviceID")
    private String deviceID;
    @Column(name = "driverStatus")
    private Integer driverStatus;
    @Column(name = "dutyStatus")
    private Short dutyStatus;
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

    public Driver() {
    }

    public Driver(DriverPK driverPK) {
        this.driverPK = driverPK;
    }

    public Driver(String accountID, String driverID) {
        this.driverPK = new DriverPK(accountID, driverID);
    }

    public DriverPK getDriverPK() {
        return driverPK;
    }

    public void setDriverPK(DriverPK driverPK) {
        this.driverPK = driverPK;
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

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Integer getLicenseExpire() {
        return licenseExpire;
    }

    public void setLicenseExpire(Integer licenseExpire) {
        this.licenseExpire = licenseExpire;
    }

    public String getBadgeID() {
        return badgeID;
    }

    public void setBadgeID(String badgeID) {
        this.badgeID = badgeID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Integer birthdate) {
        this.birthdate = birthdate;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public Integer getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(Integer driverStatus) {
        this.driverStatus = driverStatus;
    }

    public Short getDutyStatus() {
        return dutyStatus;
    }

    public void setDutyStatus(Short dutyStatus) {
        this.dutyStatus = dutyStatus;
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
        hash += (driverPK != null ? driverPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Driver)) {
            return false;
        }
        Driver other = (Driver) object;
        if ((this.driverPK == null && other.driverPK != null) || (this.driverPK != null && !this.driverPK.equals(other.driverPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.Driver[ driverPK=" + driverPK + " ]";
    }
    
}
