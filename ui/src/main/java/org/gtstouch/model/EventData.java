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
@Table(name = "EventData")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventData.findAll", query = "SELECT e FROM EventData e"),
    @NamedQuery(name = "EventData.findByAccountID", query = "SELECT e FROM EventData e WHERE e.eventDataPK.accountID = :accountID"),
    @NamedQuery(name = "EventData.findByDeviceID", query = "SELECT e FROM EventData e WHERE e.eventDataPK.deviceID = :deviceID"),
    @NamedQuery(name = "EventData.findByTimestamp", query = "SELECT e FROM EventData e WHERE e.eventDataPK.timestamp = :timestamp"),
    @NamedQuery(name = "EventData.findByStatusCode", query = "SELECT e FROM EventData e WHERE e.eventDataPK.statusCode = :statusCode"),
    @NamedQuery(name = "EventData.findByLatitude", query = "SELECT e FROM EventData e WHERE e.latitude = :latitude"),
    @NamedQuery(name = "EventData.findByLongitude", query = "SELECT e FROM EventData e WHERE e.longitude = :longitude"),
    @NamedQuery(name = "EventData.findByGpsAge", query = "SELECT e FROM EventData e WHERE e.gpsAge = :gpsAge"),
    @NamedQuery(name = "EventData.findBySpeedKPH", query = "SELECT e FROM EventData e WHERE e.speedKPH = :speedKPH"),
    @NamedQuery(name = "EventData.findByHeading", query = "SELECT e FROM EventData e WHERE e.heading = :heading"),
    @NamedQuery(name = "EventData.findByAltitude", query = "SELECT e FROM EventData e WHERE e.altitude = :altitude"),
    @NamedQuery(name = "EventData.findByTransportID", query = "SELECT e FROM EventData e WHERE e.transportID = :transportID"),
    @NamedQuery(name = "EventData.findByInputMask", query = "SELECT e FROM EventData e WHERE e.inputMask = :inputMask"),
    @NamedQuery(name = "EventData.findByOutputMask", query = "SELECT e FROM EventData e WHERE e.outputMask = :outputMask"),
    @NamedQuery(name = "EventData.findBySeatbeltMask", query = "SELECT e FROM EventData e WHERE e.seatbeltMask = :seatbeltMask"),
    @NamedQuery(name = "EventData.findByAddress", query = "SELECT e FROM EventData e WHERE e.address = :address"),
    @NamedQuery(name = "EventData.findByDataSource", query = "SELECT e FROM EventData e WHERE e.dataSource = :dataSource"),
    @NamedQuery(name = "EventData.findByDistanceKM", query = "SELECT e FROM EventData e WHERE e.distanceKM = :distanceKM"),
    @NamedQuery(name = "EventData.findByOdometerKM", query = "SELECT e FROM EventData e WHERE e.odometerKM = :odometerKM"),
    @NamedQuery(name = "EventData.findByOdometerOffsetKM", query = "SELECT e FROM EventData e WHERE e.odometerOffsetKM = :odometerOffsetKM"),
    @NamedQuery(name = "EventData.findByGeozoneIndex", query = "SELECT e FROM EventData e WHERE e.geozoneIndex = :geozoneIndex"),
    @NamedQuery(name = "EventData.findByGeozoneID", query = "SELECT e FROM EventData e WHERE e.geozoneID = :geozoneID"),
    @NamedQuery(name = "EventData.findByCreationTime", query = "SELECT e FROM EventData e WHERE e.creationTime = :creationTime")})
public class EventData implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EventDataPK eventDataPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "gpsAge")
    private Integer gpsAge;
    @Column(name = "speedKPH")
    private Double speedKPH;
    @Column(name = "heading")
    private Double heading;
    @Column(name = "altitude")
    private Double altitude;
    @Size(max = 32)
    @Column(name = "transportID")
    private String transportID;
    @Column(name = "inputMask")
    private Integer inputMask;
    @Column(name = "outputMask")
    private Integer outputMask;
    @Column(name = "seatbeltMask")
    private Integer seatbeltMask;
    @Size(max = 90)
    @Column(name = "address")
    private String address;
    @Size(max = 32)
    @Column(name = "dataSource")
    private String dataSource;
    @Lob
    @Size(max = 65535)
    @Column(name = "rawData")
    private String rawData;
    @Column(name = "distanceKM")
    private Double distanceKM;
    @Column(name = "odometerKM")
    private Double odometerKM;
    @Column(name = "odometerOffsetKM")
    private Double odometerOffsetKM;
    @Column(name = "geozoneIndex")
    private Integer geozoneIndex;
    @Size(max = 32)
    @Column(name = "geozoneID")
    private String geozoneID;
    @Column(name = "creationTime")
    private Integer creationTime;

    public EventData() {
    }

    public EventData(EventDataPK eventDataPK) {
        this.eventDataPK = eventDataPK;
    }

    public EventData(String accountID, String deviceID, int timestamp, int statusCode) {
        this.eventDataPK = new EventDataPK(accountID, deviceID, timestamp, statusCode);
    }

    public EventDataPK getEventDataPK() {
        return eventDataPK;
    }

    public void setEventDataPK(EventDataPK eventDataPK) {
        this.eventDataPK = eventDataPK;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getGpsAge() {
        return gpsAge;
    }

    public void setGpsAge(Integer gpsAge) {
        this.gpsAge = gpsAge;
    }

    public Double getSpeedKPH() {
        return speedKPH;
    }

    public void setSpeedKPH(Double speedKPH) {
        this.speedKPH = speedKPH;
    }

    public Double getHeading() {
        return heading;
    }

    public void setHeading(Double heading) {
        this.heading = heading;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public String getTransportID() {
        return transportID;
    }

    public void setTransportID(String transportID) {
        this.transportID = transportID;
    }

    public Integer getInputMask() {
        return inputMask;
    }

    public void setInputMask(Integer inputMask) {
        this.inputMask = inputMask;
    }

    public Integer getOutputMask() {
        return outputMask;
    }

    public void setOutputMask(Integer outputMask) {
        this.outputMask = outputMask;
    }

    public Integer getSeatbeltMask() {
        return seatbeltMask;
    }

    public void setSeatbeltMask(Integer seatbeltMask) {
        this.seatbeltMask = seatbeltMask;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public Double getDistanceKM() {
        return distanceKM;
    }

    public void setDistanceKM(Double distanceKM) {
        this.distanceKM = distanceKM;
    }

    public Double getOdometerKM() {
        return odometerKM;
    }

    public void setOdometerKM(Double odometerKM) {
        this.odometerKM = odometerKM;
    }

    public Double getOdometerOffsetKM() {
        return odometerOffsetKM;
    }

    public void setOdometerOffsetKM(Double odometerOffsetKM) {
        this.odometerOffsetKM = odometerOffsetKM;
    }

    public Integer getGeozoneIndex() {
        return geozoneIndex;
    }

    public void setGeozoneIndex(Integer geozoneIndex) {
        this.geozoneIndex = geozoneIndex;
    }

    public String getGeozoneID() {
        return geozoneID;
    }

    public void setGeozoneID(String geozoneID) {
        this.geozoneID = geozoneID;
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
        hash += (eventDataPK != null ? eventDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventData)) {
            return false;
        }
        EventData other = (EventData) object;
        if ((this.eventDataPK == null && other.eventDataPK != null) || (this.eventDataPK != null && !this.eventDataPK.equals(other.eventDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.EventData[ eventDataPK=" + eventDataPK + " ]";
    }
    
}
