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
import javax.persistence.Lob;
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
@Table(name = "Account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByAccountID", query = "SELECT a FROM Account a WHERE a.accountID = :accountID"),
    @NamedQuery(name = "Account.findByAccountType", query = "SELECT a FROM Account a WHERE a.accountType = :accountType"),
    @NamedQuery(name = "Account.findByNotifyEmail", query = "SELECT a FROM Account a WHERE a.notifyEmail = :notifyEmail"),
    @NamedQuery(name = "Account.findByAllowNotify", query = "SELECT a FROM Account a WHERE a.allowNotify = :allowNotify"),
    @NamedQuery(name = "Account.findBySpeedUnits", query = "SELECT a FROM Account a WHERE a.speedUnits = :speedUnits"),
    @NamedQuery(name = "Account.findByDistanceUnits", query = "SELECT a FROM Account a WHERE a.distanceUnits = :distanceUnits"),
    @NamedQuery(name = "Account.findByVolumeUnits", query = "SELECT a FROM Account a WHERE a.volumeUnits = :volumeUnits"),
    @NamedQuery(name = "Account.findByPressureUnits", query = "SELECT a FROM Account a WHERE a.pressureUnits = :pressureUnits"),
    @NamedQuery(name = "Account.findByEconomyUnits", query = "SELECT a FROM Account a WHERE a.economyUnits = :economyUnits"),
    @NamedQuery(name = "Account.findByTemperatureUnits", query = "SELECT a FROM Account a WHERE a.temperatureUnits = :temperatureUnits"),
    @NamedQuery(name = "Account.findByCurrencyUnits", query = "SELECT a FROM Account a WHERE a.currencyUnits = :currencyUnits"),
    @NamedQuery(name = "Account.findByFuelCostPerLiter", query = "SELECT a FROM Account a WHERE a.fuelCostPerLiter = :fuelCostPerLiter"),
    @NamedQuery(name = "Account.findByLatLonFormat", query = "SELECT a FROM Account a WHERE a.latLonFormat = :latLonFormat"),
    @NamedQuery(name = "Account.findByGeocoderMode", query = "SELECT a FROM Account a WHERE a.geocoderMode = :geocoderMode"),
    @NamedQuery(name = "Account.findByPrivateLabelName", query = "SELECT a FROM Account a WHERE a.privateLabelName = :privateLabelName"),
    @NamedQuery(name = "Account.findByIsBorderCrossing", query = "SELECT a FROM Account a WHERE a.isBorderCrossing = :isBorderCrossing"),
    @NamedQuery(name = "Account.findByRetainedEventAge", query = "SELECT a FROM Account a WHERE a.retainedEventAge = :retainedEventAge"),
    @NamedQuery(name = "Account.findByMaximumDevices", query = "SELECT a FROM Account a WHERE a.maximumDevices = :maximumDevices"),
    @NamedQuery(name = "Account.findByTotalPingCount", query = "SELECT a FROM Account a WHERE a.totalPingCount = :totalPingCount"),
    @NamedQuery(name = "Account.findByMaxPingCount", query = "SELECT a FROM Account a WHERE a.maxPingCount = :maxPingCount"),
    @NamedQuery(name = "Account.findByAutoAddDevices", query = "SELECT a FROM Account a WHERE a.autoAddDevices = :autoAddDevices"),
    @NamedQuery(name = "Account.findByDcsPropertiesID", query = "SELECT a FROM Account a WHERE a.dcsPropertiesID = :dcsPropertiesID"),
    @NamedQuery(name = "Account.findBySmsEnabled", query = "SELECT a FROM Account a WHERE a.smsEnabled = :smsEnabled"),
    @NamedQuery(name = "Account.findBySmsProperties", query = "SELECT a FROM Account a WHERE a.smsProperties = :smsProperties"),
    @NamedQuery(name = "Account.findByEmailProperties", query = "SELECT a FROM Account a WHERE a.emailProperties = :emailProperties"),
    @NamedQuery(name = "Account.findByExpirationTime", query = "SELECT a FROM Account a WHERE a.expirationTime = :expirationTime"),
    @NamedQuery(name = "Account.findByAllowWebService", query = "SELECT a FROM Account a WHERE a.allowWebService = :allowWebService"),
    @NamedQuery(name = "Account.findByDefaultUser", query = "SELECT a FROM Account a WHERE a.defaultUser = :defaultUser"),
    @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password"),
    @NamedQuery(name = "Account.findByContactName", query = "SELECT a FROM Account a WHERE a.contactName = :contactName"),
    @NamedQuery(name = "Account.findByContactPhone", query = "SELECT a FROM Account a WHERE a.contactPhone = :contactPhone"),
    @NamedQuery(name = "Account.findByContactEmail", query = "SELECT a FROM Account a WHERE a.contactEmail = :contactEmail"),
    @NamedQuery(name = "Account.findByTimeZone", query = "SELECT a FROM Account a WHERE a.timeZone = :timeZone"),
    @NamedQuery(name = "Account.findByPasswdChangeTime", query = "SELECT a FROM Account a WHERE a.passwdChangeTime = :passwdChangeTime"),
    @NamedQuery(name = "Account.findByPasswdQueryTime", query = "SELECT a FROM Account a WHERE a.passwdQueryTime = :passwdQueryTime"),
    @NamedQuery(name = "Account.findByLastLoginTime", query = "SELECT a FROM Account a WHERE a.lastLoginTime = :lastLoginTime"),
    @NamedQuery(name = "Account.findByIsActive", query = "SELECT a FROM Account a WHERE a.isActive = :isActive"),
    @NamedQuery(name = "Account.findByDisplayName", query = "SELECT a FROM Account a WHERE a.displayName = :displayName"),
    @NamedQuery(name = "Account.findByDescription", query = "SELECT a FROM Account a WHERE a.description = :description"),
    @NamedQuery(name = "Account.findByLastUpdateTime", query = "SELECT a FROM Account a WHERE a.lastUpdateTime = :lastUpdateTime"),
    @NamedQuery(name = "Account.findByCreationTime", query = "SELECT a FROM Account a WHERE a.creationTime = :creationTime")})
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "accountID")
    private String accountID;
    @Column(name = "accountType")
    private Short accountType;
    @Size(max = 128)
    @Column(name = "notifyEmail")
    private String notifyEmail;
    @Column(name = "allowNotify")
    private Short allowNotify;
    @Column(name = "speedUnits")
    private Short speedUnits;
    @Column(name = "distanceUnits")
    private Short distanceUnits;
    @Column(name = "volumeUnits")
    private Short volumeUnits;
    @Column(name = "pressureUnits")
    private Short pressureUnits;
    @Column(name = "economyUnits")
    private Short economyUnits;
    @Column(name = "temperatureUnits")
    private Short temperatureUnits;
    @Size(max = 8)
    @Column(name = "currencyUnits")
    private String currencyUnits;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fuelCostPerLiter")
    private Double fuelCostPerLiter;
    @Column(name = "latLonFormat")
    private Short latLonFormat;
    @Column(name = "geocoderMode")
    private Short geocoderMode;
    @Size(max = 32)
    @Column(name = "privateLabelName")
    private String privateLabelName;
    @Column(name = "isBorderCrossing")
    private Short isBorderCrossing;
    @Column(name = "retainedEventAge")
    private Integer retainedEventAge;
    @Column(name = "maximumDevices")
    private Integer maximumDevices;
    @Column(name = "totalPingCount")
    private Short totalPingCount;
    @Column(name = "maxPingCount")
    private Short maxPingCount;
    @Column(name = "autoAddDevices")
    private Short autoAddDevices;
    @Size(max = 32)
    @Column(name = "dcsPropertiesID")
    private String dcsPropertiesID;
    @Column(name = "smsEnabled")
    private Short smsEnabled;
    @Size(max = 200)
    @Column(name = "smsProperties")
    private String smsProperties;
    @Size(max = 250)
    @Column(name = "emailProperties")
    private String emailProperties;
    @Column(name = "expirationTime")
    private Integer expirationTime;
    @Column(name = "allowWebService")
    private Short allowWebService;
    @Size(max = 32)
    @Column(name = "defaultUser")
    private String defaultUser;
    @Size(max = 32)
    @Column(name = "password")
    private String password;
    @Size(max = 64)
    @Column(name = "contactName")
    private String contactName;
    @Size(max = 32)
    @Column(name = "contactPhone")
    private String contactPhone;
    @Size(max = 128)
    @Column(name = "contactEmail")
    private String contactEmail;
    @Size(max = 32)
    @Column(name = "timeZone")
    private String timeZone;
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

    public Account() {
    }

    public Account(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public Short getAccountType() {
        return accountType;
    }

    public void setAccountType(Short accountType) {
        this.accountType = accountType;
    }

    public String getNotifyEmail() {
        return notifyEmail;
    }

    public void setNotifyEmail(String notifyEmail) {
        this.notifyEmail = notifyEmail;
    }

    public Short getAllowNotify() {
        return allowNotify;
    }

    public void setAllowNotify(Short allowNotify) {
        this.allowNotify = allowNotify;
    }

    public Short getSpeedUnits() {
        return speedUnits;
    }

    public void setSpeedUnits(Short speedUnits) {
        this.speedUnits = speedUnits;
    }

    public Short getDistanceUnits() {
        return distanceUnits;
    }

    public void setDistanceUnits(Short distanceUnits) {
        this.distanceUnits = distanceUnits;
    }

    public Short getVolumeUnits() {
        return volumeUnits;
    }

    public void setVolumeUnits(Short volumeUnits) {
        this.volumeUnits = volumeUnits;
    }

    public Short getPressureUnits() {
        return pressureUnits;
    }

    public void setPressureUnits(Short pressureUnits) {
        this.pressureUnits = pressureUnits;
    }

    public Short getEconomyUnits() {
        return economyUnits;
    }

    public void setEconomyUnits(Short economyUnits) {
        this.economyUnits = economyUnits;
    }

    public Short getTemperatureUnits() {
        return temperatureUnits;
    }

    public void setTemperatureUnits(Short temperatureUnits) {
        this.temperatureUnits = temperatureUnits;
    }

    public String getCurrencyUnits() {
        return currencyUnits;
    }

    public void setCurrencyUnits(String currencyUnits) {
        this.currencyUnits = currencyUnits;
    }

    public Double getFuelCostPerLiter() {
        return fuelCostPerLiter;
    }

    public void setFuelCostPerLiter(Double fuelCostPerLiter) {
        this.fuelCostPerLiter = fuelCostPerLiter;
    }

    public Short getLatLonFormat() {
        return latLonFormat;
    }

    public void setLatLonFormat(Short latLonFormat) {
        this.latLonFormat = latLonFormat;
    }

    public Short getGeocoderMode() {
        return geocoderMode;
    }

    public void setGeocoderMode(Short geocoderMode) {
        this.geocoderMode = geocoderMode;
    }

    public String getPrivateLabelName() {
        return privateLabelName;
    }

    public void setPrivateLabelName(String privateLabelName) {
        this.privateLabelName = privateLabelName;
    }

    public Short getIsBorderCrossing() {
        return isBorderCrossing;
    }

    public void setIsBorderCrossing(Short isBorderCrossing) {
        this.isBorderCrossing = isBorderCrossing;
    }

    public Integer getRetainedEventAge() {
        return retainedEventAge;
    }

    public void setRetainedEventAge(Integer retainedEventAge) {
        this.retainedEventAge = retainedEventAge;
    }

    public Integer getMaximumDevices() {
        return maximumDevices;
    }

    public void setMaximumDevices(Integer maximumDevices) {
        this.maximumDevices = maximumDevices;
    }

    public Short getTotalPingCount() {
        return totalPingCount;
    }

    public void setTotalPingCount(Short totalPingCount) {
        this.totalPingCount = totalPingCount;
    }

    public Short getMaxPingCount() {
        return maxPingCount;
    }

    public void setMaxPingCount(Short maxPingCount) {
        this.maxPingCount = maxPingCount;
    }

    public Short getAutoAddDevices() {
        return autoAddDevices;
    }

    public void setAutoAddDevices(Short autoAddDevices) {
        this.autoAddDevices = autoAddDevices;
    }

    public String getDcsPropertiesID() {
        return dcsPropertiesID;
    }

    public void setDcsPropertiesID(String dcsPropertiesID) {
        this.dcsPropertiesID = dcsPropertiesID;
    }

    public Short getSmsEnabled() {
        return smsEnabled;
    }

    public void setSmsEnabled(Short smsEnabled) {
        this.smsEnabled = smsEnabled;
    }

    public String getSmsProperties() {
        return smsProperties;
    }

    public void setSmsProperties(String smsProperties) {
        this.smsProperties = smsProperties;
    }

    public String getEmailProperties() {
        return emailProperties;
    }

    public void setEmailProperties(String emailProperties) {
        this.emailProperties = emailProperties;
    }

    public Integer getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Integer expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Short getAllowWebService() {
        return allowWebService;
    }

    public void setAllowWebService(Short allowWebService) {
        this.allowWebService = allowWebService;
    }

    public String getDefaultUser() {
        return defaultUser;
    }

    public void setDefaultUser(String defaultUser) {
        this.defaultUser = defaultUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        hash += (accountID != null ? accountID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountID == null && other.accountID != null) || (this.accountID != null && !this.accountID.equals(other.accountID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.Account[ accountID=" + accountID + " ]";
    }
    
}
