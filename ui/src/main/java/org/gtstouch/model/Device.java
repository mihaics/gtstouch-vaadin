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
@Table(name = "Device")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d"),
    @NamedQuery(name = "Device.findByAccountID", query = "SELECT d FROM Device d WHERE d.devicePK.accountID = :accountID"),
    @NamedQuery(name = "Device.findByDeviceID", query = "SELECT d FROM Device d WHERE d.devicePK.deviceID = :deviceID"),
    @NamedQuery(name = "Device.findByGroupID", query = "SELECT d FROM Device d WHERE d.groupID = :groupID"),
    @NamedQuery(name = "Device.findByEquipmentType", query = "SELECT d FROM Device d WHERE d.equipmentType = :equipmentType"),
    @NamedQuery(name = "Device.findByEquipmentStatus", query = "SELECT d FROM Device d WHERE d.equipmentStatus = :equipmentStatus"),
    @NamedQuery(name = "Device.findByVehicleMake", query = "SELECT d FROM Device d WHERE d.vehicleMake = :vehicleMake"),
    @NamedQuery(name = "Device.findByVehicleModel", query = "SELECT d FROM Device d WHERE d.vehicleModel = :vehicleModel"),
    @NamedQuery(name = "Device.findByVehicleYear", query = "SELECT d FROM Device d WHERE d.vehicleYear = :vehicleYear"),
    @NamedQuery(name = "Device.findByVehicleID", query = "SELECT d FROM Device d WHERE d.vehicleID = :vehicleID"),
    @NamedQuery(name = "Device.findByLicensePlate", query = "SELECT d FROM Device d WHERE d.licensePlate = :licensePlate"),
    @NamedQuery(name = "Device.findByLicenseExpire", query = "SELECT d FROM Device d WHERE d.licenseExpire = :licenseExpire"),
    @NamedQuery(name = "Device.findByInsuranceExpire", query = "SELECT d FROM Device d WHERE d.insuranceExpire = :insuranceExpire"),
    @NamedQuery(name = "Device.findByDriverID", query = "SELECT d FROM Device d WHERE d.driverID = :driverID"),
    @NamedQuery(name = "Device.findByDriverStatus", query = "SELECT d FROM Device d WHERE d.driverStatus = :driverStatus"),
    @NamedQuery(name = "Device.findByFuelCapacity", query = "SELECT d FROM Device d WHERE d.fuelCapacity = :fuelCapacity"),
    @NamedQuery(name = "Device.findByFuelEconomy", query = "SELECT d FROM Device d WHERE d.fuelEconomy = :fuelEconomy"),
    @NamedQuery(name = "Device.findByFuelRatePerHour", query = "SELECT d FROM Device d WHERE d.fuelRatePerHour = :fuelRatePerHour"),
    @NamedQuery(name = "Device.findByFuelCostPerLiter", query = "SELECT d FROM Device d WHERE d.fuelCostPerLiter = :fuelCostPerLiter"),
    @NamedQuery(name = "Device.findByFuelTankProfile", query = "SELECT d FROM Device d WHERE d.fuelTankProfile = :fuelTankProfile"),
    @NamedQuery(name = "Device.findBySpeedLimitKPH", query = "SELECT d FROM Device d WHERE d.speedLimitKPH = :speedLimitKPH"),
    @NamedQuery(name = "Device.findByPlanDistanceKM", query = "SELECT d FROM Device d WHERE d.planDistanceKM = :planDistanceKM"),
    @NamedQuery(name = "Device.findByInstallTime", query = "SELECT d FROM Device d WHERE d.installTime = :installTime"),
    @NamedQuery(name = "Device.findByResetTime", query = "SELECT d FROM Device d WHERE d.resetTime = :resetTime"),
    @NamedQuery(name = "Device.findByExpirationTime", query = "SELECT d FROM Device d WHERE d.expirationTime = :expirationTime"),
    @NamedQuery(name = "Device.findByUniqueID", query = "SELECT d FROM Device d WHERE d.uniqueID = :uniqueID"),
    @NamedQuery(name = "Device.findByDeviceCode", query = "SELECT d FROM Device d WHERE d.deviceCode = :deviceCode"),
    @NamedQuery(name = "Device.findByDeviceType", query = "SELECT d FROM Device d WHERE d.deviceType = :deviceType"),
    @NamedQuery(name = "Device.findByPushpinID", query = "SELECT d FROM Device d WHERE d.pushpinID = :pushpinID"),
    @NamedQuery(name = "Device.findByDisplayColor", query = "SELECT d FROM Device d WHERE d.displayColor = :displayColor"),
    @NamedQuery(name = "Device.findBySerialNumber", query = "SELECT d FROM Device d WHERE d.serialNumber = :serialNumber"),
    @NamedQuery(name = "Device.findBySimPhoneNumber", query = "SELECT d FROM Device d WHERE d.simPhoneNumber = :simPhoneNumber"),
    @NamedQuery(name = "Device.findBySimID", query = "SELECT d FROM Device d WHERE d.simID = :simID"),
    @NamedQuery(name = "Device.findBySmsEmail", query = "SELECT d FROM Device d WHERE d.smsEmail = :smsEmail"),
    @NamedQuery(name = "Device.findByImeiNumber", query = "SELECT d FROM Device d WHERE d.imeiNumber = :imeiNumber"),
    @NamedQuery(name = "Device.findByIgnitionIndex", query = "SELECT d FROM Device d WHERE d.ignitionIndex = :ignitionIndex"),
    @NamedQuery(name = "Device.findByCodeVersion", query = "SELECT d FROM Device d WHERE d.codeVersion = :codeVersion"),
    @NamedQuery(name = "Device.findByFeatureSet", query = "SELECT d FROM Device d WHERE d.featureSet = :featureSet"),
    @NamedQuery(name = "Device.findByIpAddressValid", query = "SELECT d FROM Device d WHERE d.ipAddressValid = :ipAddressValid"),
    @NamedQuery(name = "Device.findByLastTotalConnectTime", query = "SELECT d FROM Device d WHERE d.lastTotalConnectTime = :lastTotalConnectTime"),
    @NamedQuery(name = "Device.findByLastDuplexConnectTime", query = "SELECT d FROM Device d WHERE d.lastDuplexConnectTime = :lastDuplexConnectTime"),
    @NamedQuery(name = "Device.findByLastPingTime", query = "SELECT d FROM Device d WHERE d.lastPingTime = :lastPingTime"),
    @NamedQuery(name = "Device.findByTotalPingCount", query = "SELECT d FROM Device d WHERE d.totalPingCount = :totalPingCount"),
    @NamedQuery(name = "Device.findByMaxPingCount", query = "SELECT d FROM Device d WHERE d.maxPingCount = :maxPingCount"),
    @NamedQuery(name = "Device.findByCommandStateMask", query = "SELECT d FROM Device d WHERE d.commandStateMask = :commandStateMask"),
    @NamedQuery(name = "Device.findByExpectAck", query = "SELECT d FROM Device d WHERE d.expectAck = :expectAck"),
    @NamedQuery(name = "Device.findByExpectAckCode", query = "SELECT d FROM Device d WHERE d.expectAckCode = :expectAckCode"),
    @NamedQuery(name = "Device.findByLastAckTime", query = "SELECT d FROM Device d WHERE d.lastAckTime = :lastAckTime"),
    @NamedQuery(name = "Device.findByDcsPropertiesID", query = "SELECT d FROM Device d WHERE d.dcsPropertiesID = :dcsPropertiesID"),
    @NamedQuery(name = "Device.findByDcsConfigMask", query = "SELECT d FROM Device d WHERE d.dcsConfigMask = :dcsConfigMask"),
    @NamedQuery(name = "Device.findByDcsConfigString", query = "SELECT d FROM Device d WHERE d.dcsConfigString = :dcsConfigString"),
    @NamedQuery(name = "Device.findByDcsCommandHost", query = "SELECT d FROM Device d WHERE d.dcsCommandHost = :dcsCommandHost"),
    @NamedQuery(name = "Device.findBySupportsDMTP", query = "SELECT d FROM Device d WHERE d.supportsDMTP = :supportsDMTP"),
    @NamedQuery(name = "Device.findBySupportedEncodings", query = "SELECT d FROM Device d WHERE d.supportedEncodings = :supportedEncodings"),
    @NamedQuery(name = "Device.findByUnitLimitInterval", query = "SELECT d FROM Device d WHERE d.unitLimitInterval = :unitLimitInterval"),
    @NamedQuery(name = "Device.findByMaxAllowedEvents", query = "SELECT d FROM Device d WHERE d.maxAllowedEvents = :maxAllowedEvents"),
    @NamedQuery(name = "Device.findByTotalMaxConn", query = "SELECT d FROM Device d WHERE d.totalMaxConn = :totalMaxConn"),
    @NamedQuery(name = "Device.findByTotalMaxConnPerMin", query = "SELECT d FROM Device d WHERE d.totalMaxConnPerMin = :totalMaxConnPerMin"),
    @NamedQuery(name = "Device.findByDuplexMaxConn", query = "SELECT d FROM Device d WHERE d.duplexMaxConn = :duplexMaxConn"),
    @NamedQuery(name = "Device.findByDuplexMaxConnPerMin", query = "SELECT d FROM Device d WHERE d.duplexMaxConnPerMin = :duplexMaxConnPerMin"),
    @NamedQuery(name = "Device.findByLastTcpSessionID", query = "SELECT d FROM Device d WHERE d.lastTcpSessionID = :lastTcpSessionID"),
    @NamedQuery(name = "Device.findByIpAddressCurrent", query = "SELECT d FROM Device d WHERE d.ipAddressCurrent = :ipAddressCurrent"),
    @NamedQuery(name = "Device.findByRemotePortCurrent", query = "SELECT d FROM Device d WHERE d.remotePortCurrent = :remotePortCurrent"),
    @NamedQuery(name = "Device.findByListenPortCurrent", query = "SELECT d FROM Device d WHERE d.listenPortCurrent = :listenPortCurrent"),
    @NamedQuery(name = "Device.findByLastInputState", query = "SELECT d FROM Device d WHERE d.lastInputState = :lastInputState"),
    @NamedQuery(name = "Device.findByLastOutputState", query = "SELECT d FROM Device d WHERE d.lastOutputState = :lastOutputState"),
    @NamedQuery(name = "Device.findByStatusCodeState", query = "SELECT d FROM Device d WHERE d.statusCodeState = :statusCodeState"),
    @NamedQuery(name = "Device.findByLastBatteryLevel", query = "SELECT d FROM Device d WHERE d.lastBatteryLevel = :lastBatteryLevel"),
    @NamedQuery(name = "Device.findByLastFuelLevel", query = "SELECT d FROM Device d WHERE d.lastFuelLevel = :lastFuelLevel"),
    @NamedQuery(name = "Device.findByLastFuelTotal", query = "SELECT d FROM Device d WHERE d.lastFuelTotal = :lastFuelTotal"),
    @NamedQuery(name = "Device.findByLastOilLevel", query = "SELECT d FROM Device d WHERE d.lastOilLevel = :lastOilLevel"),
    @NamedQuery(name = "Device.findByLastValidLatitude", query = "SELECT d FROM Device d WHERE d.lastValidLatitude = :lastValidLatitude"),
    @NamedQuery(name = "Device.findByLastValidLongitude", query = "SELECT d FROM Device d WHERE d.lastValidLongitude = :lastValidLongitude"),
    @NamedQuery(name = "Device.findByLastValidHeading", query = "SELECT d FROM Device d WHERE d.lastValidHeading = :lastValidHeading"),
    @NamedQuery(name = "Device.findByLastValidSpeedKPH", query = "SELECT d FROM Device d WHERE d.lastValidSpeedKPH = :lastValidSpeedKPH"),
    @NamedQuery(name = "Device.findByLastGPSTimestamp", query = "SELECT d FROM Device d WHERE d.lastGPSTimestamp = :lastGPSTimestamp"),
    @NamedQuery(name = "Device.findByLastEventTimestamp", query = "SELECT d FROM Device d WHERE d.lastEventTimestamp = :lastEventTimestamp"),
    @NamedQuery(name = "Device.findByLastCellServingInfo", query = "SELECT d FROM Device d WHERE d.lastCellServingInfo = :lastCellServingInfo"),
    @NamedQuery(name = "Device.findByLastDistanceKM", query = "SELECT d FROM Device d WHERE d.lastDistanceKM = :lastDistanceKM"),
    @NamedQuery(name = "Device.findByLastOdometerKM", query = "SELECT d FROM Device d WHERE d.lastOdometerKM = :lastOdometerKM"),
    @NamedQuery(name = "Device.findByOdometerOffsetKM", query = "SELECT d FROM Device d WHERE d.odometerOffsetKM = :odometerOffsetKM"),
    @NamedQuery(name = "Device.findByLastEngineOnHours", query = "SELECT d FROM Device d WHERE d.lastEngineOnHours = :lastEngineOnHours"),
    @NamedQuery(name = "Device.findByLastEngineOnTime", query = "SELECT d FROM Device d WHERE d.lastEngineOnTime = :lastEngineOnTime"),
    @NamedQuery(name = "Device.findByLastEngineOffTime", query = "SELECT d FROM Device d WHERE d.lastEngineOffTime = :lastEngineOffTime"),
    @NamedQuery(name = "Device.findByLastEngineHours", query = "SELECT d FROM Device d WHERE d.lastEngineHours = :lastEngineHours"),
    @NamedQuery(name = "Device.findByEngineHoursOffset", query = "SELECT d FROM Device d WHERE d.engineHoursOffset = :engineHoursOffset"),
    @NamedQuery(name = "Device.findByLastIgnitionOnHours", query = "SELECT d FROM Device d WHERE d.lastIgnitionOnHours = :lastIgnitionOnHours"),
    @NamedQuery(name = "Device.findByLastIgnitionOnTime", query = "SELECT d FROM Device d WHERE d.lastIgnitionOnTime = :lastIgnitionOnTime"),
    @NamedQuery(name = "Device.findByLastIgnitionOffTime", query = "SELECT d FROM Device d WHERE d.lastIgnitionOffTime = :lastIgnitionOffTime"),
    @NamedQuery(name = "Device.findByLastIgnitionHours", query = "SELECT d FROM Device d WHERE d.lastIgnitionHours = :lastIgnitionHours"),
    @NamedQuery(name = "Device.findByLastStopTime", query = "SELECT d FROM Device d WHERE d.lastStopTime = :lastStopTime"),
    @NamedQuery(name = "Device.findByLastStartTime", query = "SELECT d FROM Device d WHERE d.lastStartTime = :lastStartTime"),
    @NamedQuery(name = "Device.findByLastMalfunctionLamp", query = "SELECT d FROM Device d WHERE d.lastMalfunctionLamp = :lastMalfunctionLamp"),
    @NamedQuery(name = "Device.findByLastFaultCode", query = "SELECT d FROM Device d WHERE d.lastFaultCode = :lastFaultCode"),
    @NamedQuery(name = "Device.findByIsActive", query = "SELECT d FROM Device d WHERE d.isActive = :isActive"),
    @NamedQuery(name = "Device.findByDisplayName", query = "SELECT d FROM Device d WHERE d.displayName = :displayName"),
    @NamedQuery(name = "Device.findByDescription", query = "SELECT d FROM Device d WHERE d.description = :description"),
    @NamedQuery(name = "Device.findByLastUpdateTime", query = "SELECT d FROM Device d WHERE d.lastUpdateTime = :lastUpdateTime"),
    @NamedQuery(name = "Device.findByCreationTime", query = "SELECT d FROM Device d WHERE d.creationTime = :creationTime")})
public class Device implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DevicePK devicePK;
    @Size(max = 32)
    @Column(name = "groupID")
    private String groupID;
    @Size(max = 40)
    @Column(name = "equipmentType")
    private String equipmentType;
    @Size(max = 24)
    @Column(name = "equipmentStatus")
    private String equipmentStatus;
    @Size(max = 40)
    @Column(name = "vehicleMake")
    private String vehicleMake;
    @Size(max = 40)
    @Column(name = "vehicleModel")
    private String vehicleModel;
    @Column(name = "vehicleYear")
    private Short vehicleYear;
    @Size(max = 24)
    @Column(name = "vehicleID")
    private String vehicleID;
    @Size(max = 24)
    @Column(name = "licensePlate")
    private String licensePlate;
    @Column(name = "licenseExpire")
    private Integer licenseExpire;
    @Column(name = "insuranceExpire")
    private Integer insuranceExpire;
    @Size(max = 32)
    @Column(name = "driverID")
    private String driverID;
    @Column(name = "driverStatus")
    private Integer driverStatus;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fuelCapacity")
    private Double fuelCapacity;
    @Column(name = "fuelEconomy")
    private Double fuelEconomy;
    @Column(name = "fuelRatePerHour")
    private Double fuelRatePerHour;
    @Column(name = "fuelCostPerLiter")
    private Double fuelCostPerLiter;
    @Size(max = 320)
    @Column(name = "fuelTankProfile")
    private String fuelTankProfile;
    @Column(name = "speedLimitKPH")
    private Double speedLimitKPH;
    @Column(name = "planDistanceKM")
    private Double planDistanceKM;
    @Column(name = "installTime")
    private Integer installTime;
    @Column(name = "resetTime")
    private Integer resetTime;
    @Column(name = "expirationTime")
    private Integer expirationTime;
    @Size(max = 40)
    @Column(name = "uniqueID")
    private String uniqueID;
    @Size(max = 24)
    @Column(name = "deviceCode")
    private String deviceCode;
    @Size(max = 24)
    @Column(name = "deviceType")
    private String deviceType;
    @Size(max = 32)
    @Column(name = "pushpinID")
    private String pushpinID;
    @Size(max = 16)
    @Column(name = "displayColor")
    private String displayColor;
    @Size(max = 24)
    @Column(name = "serialNumber")
    private String serialNumber;
    @Size(max = 24)
    @Column(name = "simPhoneNumber")
    private String simPhoneNumber;
    @Size(max = 24)
    @Column(name = "simID")
    private String simID;
    @Size(max = 64)
    @Column(name = "smsEmail")
    private String smsEmail;
    @Size(max = 24)
    @Column(name = "imeiNumber")
    private String imeiNumber;
    @Lob
    @Size(max = 65535)
    @Column(name = "dataKey")
    private String dataKey;
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
    @Column(name = "lastTotalConnectTime")
    private Integer lastTotalConnectTime;
    @Column(name = "lastDuplexConnectTime")
    private Integer lastDuplexConnectTime;
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
    @Column(name = "commandStateMask")
    private Integer commandStateMask;
    @Column(name = "expectAck")
    private Short expectAck;
    @Column(name = "expectAckCode")
    private Integer expectAckCode;
    @Lob
    @Size(max = 65535)
    @Column(name = "lastAckCommand")
    private String lastAckCommand;
    @Column(name = "lastAckTime")
    private Integer lastAckTime;
    @Size(max = 32)
    @Column(name = "dcsPropertiesID")
    private String dcsPropertiesID;
    @Column(name = "dcsConfigMask")
    private Integer dcsConfigMask;
    @Size(max = 80)
    @Column(name = "dcsConfigString")
    private String dcsConfigString;
    @Size(max = 32)
    @Column(name = "dcsCommandHost")
    private String dcsCommandHost;
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
    @Size(max = 32)
    @Column(name = "lastTcpSessionID")
    private String lastTcpSessionID;
    @Size(max = 32)
    @Column(name = "ipAddressCurrent")
    private String ipAddressCurrent;
    @Column(name = "remotePortCurrent")
    private Short remotePortCurrent;
    @Column(name = "listenPortCurrent")
    private Short listenPortCurrent;
    @Column(name = "lastInputState")
    private Integer lastInputState;
    @Column(name = "lastOutputState")
    private Integer lastOutputState;
    @Column(name = "statusCodeState")
    private Integer statusCodeState;
    @Column(name = "lastBatteryLevel")
    private Double lastBatteryLevel;
    @Column(name = "lastFuelLevel")
    private Double lastFuelLevel;
    @Column(name = "lastFuelTotal")
    private Double lastFuelTotal;
    @Column(name = "lastOilLevel")
    private Double lastOilLevel;
    @Column(name = "lastValidLatitude")
    private Double lastValidLatitude;
    @Column(name = "lastValidLongitude")
    private Double lastValidLongitude;
    @Column(name = "lastValidHeading")
    private Double lastValidHeading;
    @Column(name = "lastValidSpeedKPH")
    private Double lastValidSpeedKPH;
    @Column(name = "lastGPSTimestamp")
    private Integer lastGPSTimestamp;
    @Column(name = "lastEventTimestamp")
    private Integer lastEventTimestamp;
    @Size(max = 100)
    @Column(name = "lastCellServingInfo")
    private String lastCellServingInfo;
    @Column(name = "lastDistanceKM")
    private Double lastDistanceKM;
    @Column(name = "lastOdometerKM")
    private Double lastOdometerKM;
    @Column(name = "odometerOffsetKM")
    private Double odometerOffsetKM;
    @Column(name = "lastEngineOnHours")
    private Double lastEngineOnHours;
    @Column(name = "lastEngineOnTime")
    private Integer lastEngineOnTime;
    @Column(name = "lastEngineOffTime")
    private Integer lastEngineOffTime;
    @Column(name = "lastEngineHours")
    private Double lastEngineHours;
    @Column(name = "engineHoursOffset")
    private Double engineHoursOffset;
    @Column(name = "lastIgnitionOnHours")
    private Double lastIgnitionOnHours;
    @Column(name = "lastIgnitionOnTime")
    private Integer lastIgnitionOnTime;
    @Column(name = "lastIgnitionOffTime")
    private Integer lastIgnitionOffTime;
    @Column(name = "lastIgnitionHours")
    private Double lastIgnitionHours;
    @Column(name = "lastStopTime")
    private Integer lastStopTime;
    @Column(name = "lastStartTime")
    private Integer lastStartTime;
    @Column(name = "lastMalfunctionLamp")
    private Short lastMalfunctionLamp;
    @Size(max = 96)
    @Column(name = "lastFaultCode")
    private String lastFaultCode;
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

    public Device() {
    }

    public Device(DevicePK devicePK) {
        this.devicePK = devicePK;
    }

    public Device(String accountID, String deviceID) {
        this.devicePK = new DevicePK(accountID, deviceID);
    }

    public DevicePK getDevicePK() {
        return devicePK;
    }

    public void setDevicePK(DevicePK devicePK) {
        this.devicePK = devicePK;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentStatus() {
        return equipmentStatus;
    }

    public void setEquipmentStatus(String equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Short getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(Short vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getLicenseExpire() {
        return licenseExpire;
    }

    public void setLicenseExpire(Integer licenseExpire) {
        this.licenseExpire = licenseExpire;
    }

    public Integer getInsuranceExpire() {
        return insuranceExpire;
    }

    public void setInsuranceExpire(Integer insuranceExpire) {
        this.insuranceExpire = insuranceExpire;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public Integer getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(Integer driverStatus) {
        this.driverStatus = driverStatus;
    }

    public Double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public Double getFuelEconomy() {
        return fuelEconomy;
    }

    public void setFuelEconomy(Double fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }

    public Double getFuelRatePerHour() {
        return fuelRatePerHour;
    }

    public void setFuelRatePerHour(Double fuelRatePerHour) {
        this.fuelRatePerHour = fuelRatePerHour;
    }

    public Double getFuelCostPerLiter() {
        return fuelCostPerLiter;
    }

    public void setFuelCostPerLiter(Double fuelCostPerLiter) {
        this.fuelCostPerLiter = fuelCostPerLiter;
    }

    public String getFuelTankProfile() {
        return fuelTankProfile;
    }

    public void setFuelTankProfile(String fuelTankProfile) {
        this.fuelTankProfile = fuelTankProfile;
    }

    public Double getSpeedLimitKPH() {
        return speedLimitKPH;
    }

    public void setSpeedLimitKPH(Double speedLimitKPH) {
        this.speedLimitKPH = speedLimitKPH;
    }

    public Double getPlanDistanceKM() {
        return planDistanceKM;
    }

    public void setPlanDistanceKM(Double planDistanceKM) {
        this.planDistanceKM = planDistanceKM;
    }

    public Integer getInstallTime() {
        return installTime;
    }

    public void setInstallTime(Integer installTime) {
        this.installTime = installTime;
    }

    public Integer getResetTime() {
        return resetTime;
    }

    public void setResetTime(Integer resetTime) {
        this.resetTime = resetTime;
    }

    public Integer getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Integer expirationTime) {
        this.expirationTime = expirationTime;
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

    public String getPushpinID() {
        return pushpinID;
    }

    public void setPushpinID(String pushpinID) {
        this.pushpinID = pushpinID;
    }

    public String getDisplayColor() {
        return displayColor;
    }

    public void setDisplayColor(String displayColor) {
        this.displayColor = displayColor;
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

    public String getSimID() {
        return simID;
    }

    public void setSimID(String simID) {
        this.simID = simID;
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

    public String getDataKey() {
        return dataKey;
    }

    public void setDataKey(String dataKey) {
        this.dataKey = dataKey;
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

    public Integer getCommandStateMask() {
        return commandStateMask;
    }

    public void setCommandStateMask(Integer commandStateMask) {
        this.commandStateMask = commandStateMask;
    }

    public Short getExpectAck() {
        return expectAck;
    }

    public void setExpectAck(Short expectAck) {
        this.expectAck = expectAck;
    }

    public Integer getExpectAckCode() {
        return expectAckCode;
    }

    public void setExpectAckCode(Integer expectAckCode) {
        this.expectAckCode = expectAckCode;
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

    public String getDcsPropertiesID() {
        return dcsPropertiesID;
    }

    public void setDcsPropertiesID(String dcsPropertiesID) {
        this.dcsPropertiesID = dcsPropertiesID;
    }

    public Integer getDcsConfigMask() {
        return dcsConfigMask;
    }

    public void setDcsConfigMask(Integer dcsConfigMask) {
        this.dcsConfigMask = dcsConfigMask;
    }

    public String getDcsConfigString() {
        return dcsConfigString;
    }

    public void setDcsConfigString(String dcsConfigString) {
        this.dcsConfigString = dcsConfigString;
    }

    public String getDcsCommandHost() {
        return dcsCommandHost;
    }

    public void setDcsCommandHost(String dcsCommandHost) {
        this.dcsCommandHost = dcsCommandHost;
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

    public String getLastTcpSessionID() {
        return lastTcpSessionID;
    }

    public void setLastTcpSessionID(String lastTcpSessionID) {
        this.lastTcpSessionID = lastTcpSessionID;
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

    public Integer getStatusCodeState() {
        return statusCodeState;
    }

    public void setStatusCodeState(Integer statusCodeState) {
        this.statusCodeState = statusCodeState;
    }

    public Double getLastBatteryLevel() {
        return lastBatteryLevel;
    }

    public void setLastBatteryLevel(Double lastBatteryLevel) {
        this.lastBatteryLevel = lastBatteryLevel;
    }

    public Double getLastFuelLevel() {
        return lastFuelLevel;
    }

    public void setLastFuelLevel(Double lastFuelLevel) {
        this.lastFuelLevel = lastFuelLevel;
    }

    public Double getLastFuelTotal() {
        return lastFuelTotal;
    }

    public void setLastFuelTotal(Double lastFuelTotal) {
        this.lastFuelTotal = lastFuelTotal;
    }

    public Double getLastOilLevel() {
        return lastOilLevel;
    }

    public void setLastOilLevel(Double lastOilLevel) {
        this.lastOilLevel = lastOilLevel;
    }

    public Double getLastValidLatitude() {
        return lastValidLatitude;
    }

    public void setLastValidLatitude(Double lastValidLatitude) {
        this.lastValidLatitude = lastValidLatitude;
    }

    public Double getLastValidLongitude() {
        return lastValidLongitude;
    }

    public void setLastValidLongitude(Double lastValidLongitude) {
        this.lastValidLongitude = lastValidLongitude;
    }

    public Double getLastValidHeading() {
        return lastValidHeading;
    }

    public void setLastValidHeading(Double lastValidHeading) {
        this.lastValidHeading = lastValidHeading;
    }

    public Double getLastValidSpeedKPH() {
        return lastValidSpeedKPH;
    }

    public void setLastValidSpeedKPH(Double lastValidSpeedKPH) {
        this.lastValidSpeedKPH = lastValidSpeedKPH;
    }

    public Integer getLastGPSTimestamp() {
        return lastGPSTimestamp;
    }

    public void setLastGPSTimestamp(Integer lastGPSTimestamp) {
        this.lastGPSTimestamp = lastGPSTimestamp;
    }

    public Integer getLastEventTimestamp() {
        return lastEventTimestamp;
    }

    public void setLastEventTimestamp(Integer lastEventTimestamp) {
        this.lastEventTimestamp = lastEventTimestamp;
    }

    public String getLastCellServingInfo() {
        return lastCellServingInfo;
    }

    public void setLastCellServingInfo(String lastCellServingInfo) {
        this.lastCellServingInfo = lastCellServingInfo;
    }

    public Double getLastDistanceKM() {
        return lastDistanceKM;
    }

    public void setLastDistanceKM(Double lastDistanceKM) {
        this.lastDistanceKM = lastDistanceKM;
    }

    public Double getLastOdometerKM() {
        return lastOdometerKM;
    }

    public void setLastOdometerKM(Double lastOdometerKM) {
        this.lastOdometerKM = lastOdometerKM;
    }

    public Double getOdometerOffsetKM() {
        return odometerOffsetKM;
    }

    public void setOdometerOffsetKM(Double odometerOffsetKM) {
        this.odometerOffsetKM = odometerOffsetKM;
    }

    public Double getLastEngineOnHours() {
        return lastEngineOnHours;
    }

    public void setLastEngineOnHours(Double lastEngineOnHours) {
        this.lastEngineOnHours = lastEngineOnHours;
    }

    public Integer getLastEngineOnTime() {
        return lastEngineOnTime;
    }

    public void setLastEngineOnTime(Integer lastEngineOnTime) {
        this.lastEngineOnTime = lastEngineOnTime;
    }

    public Integer getLastEngineOffTime() {
        return lastEngineOffTime;
    }

    public void setLastEngineOffTime(Integer lastEngineOffTime) {
        this.lastEngineOffTime = lastEngineOffTime;
    }

    public Double getLastEngineHours() {
        return lastEngineHours;
    }

    public void setLastEngineHours(Double lastEngineHours) {
        this.lastEngineHours = lastEngineHours;
    }

    public Double getEngineHoursOffset() {
        return engineHoursOffset;
    }

    public void setEngineHoursOffset(Double engineHoursOffset) {
        this.engineHoursOffset = engineHoursOffset;
    }

    public Double getLastIgnitionOnHours() {
        return lastIgnitionOnHours;
    }

    public void setLastIgnitionOnHours(Double lastIgnitionOnHours) {
        this.lastIgnitionOnHours = lastIgnitionOnHours;
    }

    public Integer getLastIgnitionOnTime() {
        return lastIgnitionOnTime;
    }

    public void setLastIgnitionOnTime(Integer lastIgnitionOnTime) {
        this.lastIgnitionOnTime = lastIgnitionOnTime;
    }

    public Integer getLastIgnitionOffTime() {
        return lastIgnitionOffTime;
    }

    public void setLastIgnitionOffTime(Integer lastIgnitionOffTime) {
        this.lastIgnitionOffTime = lastIgnitionOffTime;
    }

    public Double getLastIgnitionHours() {
        return lastIgnitionHours;
    }

    public void setLastIgnitionHours(Double lastIgnitionHours) {
        this.lastIgnitionHours = lastIgnitionHours;
    }

    public Integer getLastStopTime() {
        return lastStopTime;
    }

    public void setLastStopTime(Integer lastStopTime) {
        this.lastStopTime = lastStopTime;
    }

    public Integer getLastStartTime() {
        return lastStartTime;
    }

    public void setLastStartTime(Integer lastStartTime) {
        this.lastStartTime = lastStartTime;
    }

    public Short getLastMalfunctionLamp() {
        return lastMalfunctionLamp;
    }

    public void setLastMalfunctionLamp(Short lastMalfunctionLamp) {
        this.lastMalfunctionLamp = lastMalfunctionLamp;
    }

    public String getLastFaultCode() {
        return lastFaultCode;
    }

    public void setLastFaultCode(String lastFaultCode) {
        this.lastFaultCode = lastFaultCode;
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
        hash += (devicePK != null ? devicePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Device)) {
            return false;
        }
        Device other = (Device) object;
        if ((this.devicePK == null && other.devicePK != null) || (this.devicePK != null && !this.devicePK.equals(other.devicePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.Device[ devicePK=" + devicePK + " ]";
    }
    
}
