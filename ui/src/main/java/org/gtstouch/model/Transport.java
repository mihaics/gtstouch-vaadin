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
@Table(name = "Transport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transport.findAll", query = "SELECT t FROM Transport t"),
    @NamedQuery(name = "Transport.findByAccountID", query = "SELECT t FROM Transport t WHERE t.transportPK.accountID = :accountID"),
    @NamedQuery(name = "Transport.findByTransportID", query = "SELECT t FROM Transport t WHERE t.transportPK.transportID = :transportID"),
    @NamedQuery(name = "Transport.findByAssocAccountID", query = "SELECT t FROM Transport t WHERE t.assocAccountID = :assocAccountID"),
    @NamedQuery(name = "Transport.findByAssocDeviceID", query = "SELECT t FROM Transport t WHERE t.assocDeviceID = :assocDeviceID"),
    @NamedQuery(name = "Transport.findByUniqueID", query = "SELECT t FROM Transport t WHERE t.uniqueID = :uniqueID"),
    @NamedQuery(name = "Transport.findByDeviceCode", query = "SELECT t FROM Transport t WHERE t.deviceCode = :deviceCode"),
    @NamedQuery(name = "Transport.findByDeviceType", query = "SELECT t FROM Transport t WHERE t.deviceType = :deviceType"),
    @NamedQuery(name = "Transport.findBySerialNumber", query = "SELECT t FROM Transport t WHERE t.serialNumber = :serialNumber"),
    @NamedQuery(name = "Transport.findBySimPhoneNumber", query = "SELECT t FROM Transport t WHERE t.simPhoneNumber = :simPhoneNumber"),
    @NamedQuery(name = "Transport.findBySmsEmail", query = "SELECT t FROM Transport t WHERE t.smsEmail = :smsEmail"),
    @NamedQuery(name = "Transport.findByImeiNumber", query = "SELECT t FROM Transport t WHERE t.imeiNumber = :imeiNumber"),
    @NamedQuery(name = "Transport.findByLastInputState", query = "SELECT t FROM Transport t WHERE t.lastInputState = :lastInputState"),
    @NamedQuery(name = "Transport.findByLastOutputState", query = "SELECT t FROM Transport t WHERE t.lastOutputState = :lastOutputState"),
    @NamedQuery(name = "Transport.findByIgnitionIndex", query = "SELECT t FROM Transport t WHERE t.ignitionIndex = :ignitionIndex"),
    @NamedQuery(name = "Transport.findByCodeVersion", query = "SELECT t FROM Transport t WHERE t.codeVersion = :codeVersion"),
    @NamedQuery(name = "Transport.findByFeatureSet", query = "SELECT t FROM Transport t WHERE t.featureSet = :featureSet"),
    @NamedQuery(name = "Transport.findByIpAddressValid", query = "SELECT t FROM Transport t WHERE t.ipAddressValid = :ipAddressValid"),
    @NamedQuery(name = "Transport.findByIpAddressCurrent", query = "SELECT t FROM Transport t WHERE t.ipAddressCurrent = :ipAddressCurrent"),
    @NamedQuery(name = "Transport.findByRemotePortCurrent", query = "SELECT t FROM Transport t WHERE t.remotePortCurrent = :remotePortCurrent"),
    @NamedQuery(name = "Transport.findByListenPortCurrent", query = "SELECT t FROM Transport t WHERE t.listenPortCurrent = :listenPortCurrent"),
    @NamedQuery(name = "Transport.findByLastPingTime", query = "SELECT t FROM Transport t WHERE t.lastPingTime = :lastPingTime"),
    @NamedQuery(name = "Transport.findByTotalPingCount", query = "SELECT t FROM Transport t WHERE t.totalPingCount = :totalPingCount"),
    @NamedQuery(name = "Transport.findByMaxPingCount", query = "SELECT t FROM Transport t WHERE t.maxPingCount = :maxPingCount"),
    @NamedQuery(name = "Transport.findByExpectAck", query = "SELECT t FROM Transport t WHERE t.expectAck = :expectAck"),
    @NamedQuery(name = "Transport.findByLastAckTime", query = "SELECT t FROM Transport t WHERE t.lastAckTime = :lastAckTime"),
    @NamedQuery(name = "Transport.findBySupportsDMTP", query = "SELECT t FROM Transport t WHERE t.supportsDMTP = :supportsDMTP"),
    @NamedQuery(name = "Transport.findBySupportedEncodings", query = "SELECT t FROM Transport t WHERE t.supportedEncodings = :supportedEncodings"),
    @NamedQuery(name = "Transport.findByUnitLimitInterval", query = "SELECT t FROM Transport t WHERE t.unitLimitInterval = :unitLimitInterval"),
    @NamedQuery(name = "Transport.findByMaxAllowedEvents", query = "SELECT t FROM Transport t WHERE t.maxAllowedEvents = :maxAllowedEvents"),
    @NamedQuery(name = "Transport.findByTotalMaxConn", query = "SELECT t FROM Transport t WHERE t.totalMaxConn = :totalMaxConn"),
    @NamedQuery(name = "Transport.findByTotalMaxConnPerMin", query = "SELECT t FROM Transport t WHERE t.totalMaxConnPerMin = :totalMaxConnPerMin"),
    @NamedQuery(name = "Transport.findByDuplexMaxConn", query = "SELECT t FROM Transport t WHERE t.duplexMaxConn = :duplexMaxConn"),
    @NamedQuery(name = "Transport.findByDuplexMaxConnPerMin", query = "SELECT t FROM Transport t WHERE t.duplexMaxConnPerMin = :duplexMaxConnPerMin"),
    @NamedQuery(name = "Transport.findByLastTotalConnectTime", query = "SELECT t FROM Transport t WHERE t.lastTotalConnectTime = :lastTotalConnectTime"),
    @NamedQuery(name = "Transport.findByLastDuplexConnectTime", query = "SELECT t FROM Transport t WHERE t.lastDuplexConnectTime = :lastDuplexConnectTime"),
    @NamedQuery(name = "Transport.findByDisplayName", query = "SELECT t FROM Transport t WHERE t.displayName = :displayName"),
    @NamedQuery(name = "Transport.findByDescription", query = "SELECT t FROM Transport t WHERE t.description = :description"),
    @NamedQuery(name = "Transport.findByLastUpdateTime", query = "SELECT t FROM Transport t WHERE t.lastUpdateTime = :lastUpdateTime"),
    @NamedQuery(name = "Transport.findByCreationTime", query = "SELECT t FROM Transport t WHERE t.creationTime = :creationTime")})
public class Transport implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransportPK transportPK;
    @Size(max = 32)
    @Column(name = "assocAccountID")
    private String assocAccountID;
    @Size(max = 32)
    @Column(name = "assocDeviceID")
    private String assocDeviceID;
    @Size(max = 40)
    @Column(name = "uniqueID")
    private String uniqueID;
    @Size(max = 24)
    @Column(name = "deviceCode")
    private String deviceCode;
    @Size(max = 24)
    @Column(name = "deviceType")
    private String deviceType;
    @Size(max = 24)
    @Column(name = "serialNumber")
    private String serialNumber;
    @Size(max = 24)
    @Column(name = "simPhoneNumber")
    private String simPhoneNumber;
    @Size(max = 64)
    @Column(name = "smsEmail")
    private String smsEmail;
    @Size(max = 24)
    @Column(name = "imeiNumber")
    private String imeiNumber;
    @Column(name = "lastInputState")
    private Integer lastInputState;
    @Column(name = "lastOutputState")
    private Integer lastOutputState;
    @Column(name = "ignitionIndex")
    private Short ignitionIndex;
    @Size(max = 32)
    @Column(name = "codeVersion")
    private String codeVersion;
    @Size(max = 64)
    @Column(name = "featureSet")
    private String featureSet;
    @Size(max = 128)
    @Column(name = "ipAddressValid")
    private String ipAddressValid;
    @Size(max = 32)
    @Column(name = "ipAddressCurrent")
    private String ipAddressCurrent;
    @Column(name = "remotePortCurrent")
    private Short remotePortCurrent;
    @Column(name = "listenPortCurrent")
    private Short listenPortCurrent;
    @Lob
    @Size(max = 65535)
    @Column(name = "pendingPingCommand")
    private String pendingPingCommand;
    @Column(name = "lastPingTime")
    private Integer lastPingTime;
    @Column(name = "totalPingCount")
    private Short totalPingCount;
    @Column(name = "maxPingCount")
    private Short maxPingCount;
    @Column(name = "expectAck")
    private Short expectAck;
    @Lob
    @Size(max = 65535)
    @Column(name = "lastAckCommand")
    private String lastAckCommand;
    @Column(name = "lastAckTime")
    private Integer lastAckTime;
    @Column(name = "supportsDMTP")
    private Short supportsDMTP;
    @Column(name = "supportedEncodings")
    private Short supportedEncodings;
    @Column(name = "unitLimitInterval")
    private Short unitLimitInterval;
    @Column(name = "maxAllowedEvents")
    private Short maxAllowedEvents;
    @Lob
    @Column(name = "totalProfileMask")
    private byte[] totalProfileMask;
    @Column(name = "totalMaxConn")
    private Short totalMaxConn;
    @Column(name = "totalMaxConnPerMin")
    private Short totalMaxConnPerMin;
    @Lob
    @Column(name = "duplexProfileMask")
    private byte[] duplexProfileMask;
    @Column(name = "duplexMaxConn")
    private Short duplexMaxConn;
    @Column(name = "duplexMaxConnPerMin")
    private Short duplexMaxConnPerMin;
    @Column(name = "lastTotalConnectTime")
    private Integer lastTotalConnectTime;
    @Column(name = "lastDuplexConnectTime")
    private Integer lastDuplexConnectTime;
    @Size(max = 40)
    @Column(name = "displayName")
    private String displayName;
    @Size(max = 128)
    @Column(name = "description")
    private String description;
    @Column(name = "lastUpdateTime")
    private Integer lastUpdateTime;
    @Column(name = "creationTime")
    private Integer creationTime;

    public Transport() {
    }

    public Transport(TransportPK transportPK) {
        this.transportPK = transportPK;
    }

    public Transport(String accountID, String transportID) {
        this.transportPK = new TransportPK(accountID, transportID);
    }

    public TransportPK getTransportPK() {
        return transportPK;
    }

    public void setTransportPK(TransportPK transportPK) {
        this.transportPK = transportPK;
    }

    public String getAssocAccountID() {
        return assocAccountID;
    }

    public void setAssocAccountID(String assocAccountID) {
        this.assocAccountID = assocAccountID;
    }

    public String getAssocDeviceID() {
        return assocDeviceID;
    }

    public void setAssocDeviceID(String assocDeviceID) {
        this.assocDeviceID = assocDeviceID;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSimPhoneNumber() {
        return simPhoneNumber;
    }

    public void setSimPhoneNumber(String simPhoneNumber) {
        this.simPhoneNumber = simPhoneNumber;
    }

    public String getSmsEmail() {
        return smsEmail;
    }

    public void setSmsEmail(String smsEmail) {
        this.smsEmail = smsEmail;
    }

    public String getImeiNumber() {
        return imeiNumber;
    }

    public void setImeiNumber(String imeiNumber) {
        this.imeiNumber = imeiNumber;
    }

    public Integer getLastInputState() {
        return lastInputState;
    }

    public void setLastInputState(Integer lastInputState) {
        this.lastInputState = lastInputState;
    }

    public Integer getLastOutputState() {
        return lastOutputState;
    }

    public void setLastOutputState(Integer lastOutputState) {
        this.lastOutputState = lastOutputState;
    }

    public Short getIgnitionIndex() {
        return ignitionIndex;
    }

    public void setIgnitionIndex(Short ignitionIndex) {
        this.ignitionIndex = ignitionIndex;
    }

    public String getCodeVersion() {
        return codeVersion;
    }

    public void setCodeVersion(String codeVersion) {
        this.codeVersion = codeVersion;
    }

    public String getFeatureSet() {
        return featureSet;
    }

    public void setFeatureSet(String featureSet) {
        this.featureSet = featureSet;
    }

    public String getIpAddressValid() {
        return ipAddressValid;
    }

    public void setIpAddressValid(String ipAddressValid) {
        this.ipAddressValid = ipAddressValid;
    }

    public String getIpAddressCurrent() {
        return ipAddressCurrent;
    }

    public void setIpAddressCurrent(String ipAddressCurrent) {
        this.ipAddressCurrent = ipAddressCurrent;
    }

    public Short getRemotePortCurrent() {
        return remotePortCurrent;
    }

    public void setRemotePortCurrent(Short remotePortCurrent) {
        this.remotePortCurrent = remotePortCurrent;
    }

    public Short getListenPortCurrent() {
        return listenPortCurrent;
    }

    public void setListenPortCurrent(Short listenPortCurrent) {
        this.listenPortCurrent = listenPortCurrent;
    }

    public String getPendingPingCommand() {
        return pendingPingCommand;
    }

    public void setPendingPingCommand(String pendingPingCommand) {
        this.pendingPingCommand = pendingPingCommand;
    }

    public Integer getLastPingTime() {
        return lastPingTime;
    }

    public void setLastPingTime(Integer lastPingTime) {
        this.lastPingTime = lastPingTime;
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

    public Short getExpectAck() {
        return expectAck;
    }

    public void setExpectAck(Short expectAck) {
        this.expectAck = expectAck;
    }

    public String getLastAckCommand() {
        return lastAckCommand;
    }

    public void setLastAckCommand(String lastAckCommand) {
        this.lastAckCommand = lastAckCommand;
    }

    public Integer getLastAckTime() {
        return lastAckTime;
    }

    public void setLastAckTime(Integer lastAckTime) {
        this.lastAckTime = lastAckTime;
    }

    public Short getSupportsDMTP() {
        return supportsDMTP;
    }

    public void setSupportsDMTP(Short supportsDMTP) {
        this.supportsDMTP = supportsDMTP;
    }

    public Short getSupportedEncodings() {
        return supportedEncodings;
    }

    public void setSupportedEncodings(Short supportedEncodings) {
        this.supportedEncodings = supportedEncodings;
    }

    public Short getUnitLimitInterval() {
        return unitLimitInterval;
    }

    public void setUnitLimitInterval(Short unitLimitInterval) {
        this.unitLimitInterval = unitLimitInterval;
    }

    public Short getMaxAllowedEvents() {
        return maxAllowedEvents;
    }

    public void setMaxAllowedEvents(Short maxAllowedEvents) {
        this.maxAllowedEvents = maxAllowedEvents;
    }

    public byte[] getTotalProfileMask() {
        return totalProfileMask;
    }

    public void setTotalProfileMask(byte[] totalProfileMask) {
        this.totalProfileMask = totalProfileMask;
    }

    public Short getTotalMaxConn() {
        return totalMaxConn;
    }

    public void setTotalMaxConn(Short totalMaxConn) {
        this.totalMaxConn = totalMaxConn;
    }

    public Short getTotalMaxConnPerMin() {
        return totalMaxConnPerMin;
    }

    public void setTotalMaxConnPerMin(Short totalMaxConnPerMin) {
        this.totalMaxConnPerMin = totalMaxConnPerMin;
    }

    public byte[] getDuplexProfileMask() {
        return duplexProfileMask;
    }

    public void setDuplexProfileMask(byte[] duplexProfileMask) {
        this.duplexProfileMask = duplexProfileMask;
    }

    public Short getDuplexMaxConn() {
        return duplexMaxConn;
    }

    public void setDuplexMaxConn(Short duplexMaxConn) {
        this.duplexMaxConn = duplexMaxConn;
    }

    public Short getDuplexMaxConnPerMin() {
        return duplexMaxConnPerMin;
    }

    public void setDuplexMaxConnPerMin(Short duplexMaxConnPerMin) {
        this.duplexMaxConnPerMin = duplexMaxConnPerMin;
    }

    public Integer getLastTotalConnectTime() {
        return lastTotalConnectTime;
    }

    public void setLastTotalConnectTime(Integer lastTotalConnectTime) {
        this.lastTotalConnectTime = lastTotalConnectTime;
    }

    public Integer getLastDuplexConnectTime() {
        return lastDuplexConnectTime;
    }

    public void setLastDuplexConnectTime(Integer lastDuplexConnectTime) {
        this.lastDuplexConnectTime = lastDuplexConnectTime;
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
        hash += (transportPK != null ? transportPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transport)) {
            return false;
        }
        Transport other = (Transport) object;
        if ((this.transportPK == null && other.transportPK != null) || (this.transportPK != null && !this.transportPK.equals(other.transportPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.Transport[ transportPK=" + transportPK + " ]";
    }
    
}
