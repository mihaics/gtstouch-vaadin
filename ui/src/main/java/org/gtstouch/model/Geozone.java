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
@Table(name = "Geozone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Geozone.findAll", query = "SELECT g FROM Geozone g"),
    @NamedQuery(name = "Geozone.findByAccountID", query = "SELECT g FROM Geozone g WHERE g.geozonePK.accountID = :accountID"),
    @NamedQuery(name = "Geozone.findByGeozoneID", query = "SELECT g FROM Geozone g WHERE g.geozonePK.geozoneID = :geozoneID"),
    @NamedQuery(name = "Geozone.findBySortID", query = "SELECT g FROM Geozone g WHERE g.geozonePK.sortID = :sortID"),
    @NamedQuery(name = "Geozone.findByMinLatitude", query = "SELECT g FROM Geozone g WHERE g.minLatitude = :minLatitude"),
    @NamedQuery(name = "Geozone.findByMaxLatitude", query = "SELECT g FROM Geozone g WHERE g.maxLatitude = :maxLatitude"),
    @NamedQuery(name = "Geozone.findByMinLongitude", query = "SELECT g FROM Geozone g WHERE g.minLongitude = :minLongitude"),
    @NamedQuery(name = "Geozone.findByMaxLongitude", query = "SELECT g FROM Geozone g WHERE g.maxLongitude = :maxLongitude"),
    @NamedQuery(name = "Geozone.findByZonePurposeID", query = "SELECT g FROM Geozone g WHERE g.zonePurposeID = :zonePurposeID"),
    @NamedQuery(name = "Geozone.findByReverseGeocode", query = "SELECT g FROM Geozone g WHERE g.reverseGeocode = :reverseGeocode"),
    @NamedQuery(name = "Geozone.findByArrivalZone", query = "SELECT g FROM Geozone g WHERE g.arrivalZone = :arrivalZone"),
    @NamedQuery(name = "Geozone.findByArrivalStatusCode", query = "SELECT g FROM Geozone g WHERE g.arrivalStatusCode = :arrivalStatusCode"),
    @NamedQuery(name = "Geozone.findByDepartureZone", query = "SELECT g FROM Geozone g WHERE g.departureZone = :departureZone"),
    @NamedQuery(name = "Geozone.findByDepartureStatusCode", query = "SELECT g FROM Geozone g WHERE g.departureStatusCode = :departureStatusCode"),
    @NamedQuery(name = "Geozone.findByAutoNotify", query = "SELECT g FROM Geozone g WHERE g.autoNotify = :autoNotify"),
    @NamedQuery(name = "Geozone.findByZoomRegion", query = "SELECT g FROM Geozone g WHERE g.zoomRegion = :zoomRegion"),
    @NamedQuery(name = "Geozone.findByShapeColor", query = "SELECT g FROM Geozone g WHERE g.shapeColor = :shapeColor"),
    @NamedQuery(name = "Geozone.findByIconName", query = "SELECT g FROM Geozone g WHERE g.iconName = :iconName"),
    @NamedQuery(name = "Geozone.findByZoneType", query = "SELECT g FROM Geozone g WHERE g.zoneType = :zoneType"),
    @NamedQuery(name = "Geozone.findByRadius", query = "SELECT g FROM Geozone g WHERE g.radius = :radius"),
    @NamedQuery(name = "Geozone.findByLatitude1", query = "SELECT g FROM Geozone g WHERE g.latitude1 = :latitude1"),
    @NamedQuery(name = "Geozone.findByLongitude1", query = "SELECT g FROM Geozone g WHERE g.longitude1 = :longitude1"),
    @NamedQuery(name = "Geozone.findByLatitude2", query = "SELECT g FROM Geozone g WHERE g.latitude2 = :latitude2"),
    @NamedQuery(name = "Geozone.findByLongitude2", query = "SELECT g FROM Geozone g WHERE g.longitude2 = :longitude2"),
    @NamedQuery(name = "Geozone.findByLatitude3", query = "SELECT g FROM Geozone g WHERE g.latitude3 = :latitude3"),
    @NamedQuery(name = "Geozone.findByLongitude3", query = "SELECT g FROM Geozone g WHERE g.longitude3 = :longitude3"),
    @NamedQuery(name = "Geozone.findByLatitude4", query = "SELECT g FROM Geozone g WHERE g.latitude4 = :latitude4"),
    @NamedQuery(name = "Geozone.findByLongitude4", query = "SELECT g FROM Geozone g WHERE g.longitude4 = :longitude4"),
    @NamedQuery(name = "Geozone.findByLatitude5", query = "SELECT g FROM Geozone g WHERE g.latitude5 = :latitude5"),
    @NamedQuery(name = "Geozone.findByLongitude5", query = "SELECT g FROM Geozone g WHERE g.longitude5 = :longitude5"),
    @NamedQuery(name = "Geozone.findByLatitude6", query = "SELECT g FROM Geozone g WHERE g.latitude6 = :latitude6"),
    @NamedQuery(name = "Geozone.findByLongitude6", query = "SELECT g FROM Geozone g WHERE g.longitude6 = :longitude6"),
    @NamedQuery(name = "Geozone.findByLatitude7", query = "SELECT g FROM Geozone g WHERE g.latitude7 = :latitude7"),
    @NamedQuery(name = "Geozone.findByLongitude7", query = "SELECT g FROM Geozone g WHERE g.longitude7 = :longitude7"),
    @NamedQuery(name = "Geozone.findByLatitude8", query = "SELECT g FROM Geozone g WHERE g.latitude8 = :latitude8"),
    @NamedQuery(name = "Geozone.findByLongitude8", query = "SELECT g FROM Geozone g WHERE g.longitude8 = :longitude8"),
    @NamedQuery(name = "Geozone.findByLatitude9", query = "SELECT g FROM Geozone g WHERE g.latitude9 = :latitude9"),
    @NamedQuery(name = "Geozone.findByLongitude9", query = "SELECT g FROM Geozone g WHERE g.longitude9 = :longitude9"),
    @NamedQuery(name = "Geozone.findByLatitude10", query = "SELECT g FROM Geozone g WHERE g.latitude10 = :latitude10"),
    @NamedQuery(name = "Geozone.findByLongitude10", query = "SELECT g FROM Geozone g WHERE g.longitude10 = :longitude10"),
    @NamedQuery(name = "Geozone.findByClientUpload", query = "SELECT g FROM Geozone g WHERE g.clientUpload = :clientUpload"),
    @NamedQuery(name = "Geozone.findByClientID", query = "SELECT g FROM Geozone g WHERE g.clientID = :clientID"),
    @NamedQuery(name = "Geozone.findByGroupID", query = "SELECT g FROM Geozone g WHERE g.groupID = :groupID"),
    @NamedQuery(name = "Geozone.findByStreetAddress", query = "SELECT g FROM Geozone g WHERE g.streetAddress = :streetAddress"),
    @NamedQuery(name = "Geozone.findByCity", query = "SELECT g FROM Geozone g WHERE g.city = :city"),
    @NamedQuery(name = "Geozone.findByStateProvince", query = "SELECT g FROM Geozone g WHERE g.stateProvince = :stateProvince"),
    @NamedQuery(name = "Geozone.findByPostalCode", query = "SELECT g FROM Geozone g WHERE g.postalCode = :postalCode"),
    @NamedQuery(name = "Geozone.findByCountry", query = "SELECT g FROM Geozone g WHERE g.country = :country"),
    @NamedQuery(name = "Geozone.findBySubdivision", query = "SELECT g FROM Geozone g WHERE g.subdivision = :subdivision"),
    @NamedQuery(name = "Geozone.findByContactPhone", query = "SELECT g FROM Geozone g WHERE g.contactPhone = :contactPhone"),
    @NamedQuery(name = "Geozone.findByIsActive", query = "SELECT g FROM Geozone g WHERE g.isActive = :isActive"),
    @NamedQuery(name = "Geozone.findByDisplayName", query = "SELECT g FROM Geozone g WHERE g.displayName = :displayName"),
    @NamedQuery(name = "Geozone.findByDescription", query = "SELECT g FROM Geozone g WHERE g.description = :description"),
    @NamedQuery(name = "Geozone.findByLastUpdateTime", query = "SELECT g FROM Geozone g WHERE g.lastUpdateTime = :lastUpdateTime"),
    @NamedQuery(name = "Geozone.findByCreationTime", query = "SELECT g FROM Geozone g WHERE g.creationTime = :creationTime")})
public class Geozone implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GeozonePK geozonePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "minLatitude")
    private Double minLatitude;
    @Column(name = "maxLatitude")
    private Double maxLatitude;
    @Column(name = "minLongitude")
    private Double minLongitude;
    @Column(name = "maxLongitude")
    private Double maxLongitude;
    @Size(max = 32)
    @Column(name = "zonePurposeID")
    private String zonePurposeID;
    @Column(name = "reverseGeocode")
    private Short reverseGeocode;
    @Column(name = "arrivalZone")
    private Short arrivalZone;
    @Column(name = "arrivalStatusCode")
    private Integer arrivalStatusCode;
    @Column(name = "departureZone")
    private Short departureZone;
    @Column(name = "departureStatusCode")
    private Integer departureStatusCode;
    @Column(name = "autoNotify")
    private Short autoNotify;
    @Column(name = "zoomRegion")
    private Short zoomRegion;
    @Size(max = 12)
    @Column(name = "shapeColor")
    private String shapeColor;
    @Size(max = 24)
    @Column(name = "iconName")
    private String iconName;
    @Column(name = "zoneType")
    private Short zoneType;
    @Column(name = "radius")
    private Integer radius;
    @Lob
    @Size(max = 65535)
    @Column(name = "vertices")
    private String vertices;
    @Column(name = "latitude1")
    private Double latitude1;
    @Column(name = "longitude1")
    private Double longitude1;
    @Column(name = "latitude2")
    private Double latitude2;
    @Column(name = "longitude2")
    private Double longitude2;
    @Column(name = "latitude3")
    private Double latitude3;
    @Column(name = "longitude3")
    private Double longitude3;
    @Column(name = "latitude4")
    private Double latitude4;
    @Column(name = "longitude4")
    private Double longitude4;
    @Column(name = "latitude5")
    private Double latitude5;
    @Column(name = "longitude5")
    private Double longitude5;
    @Column(name = "latitude6")
    private Double latitude6;
    @Column(name = "longitude6")
    private Double longitude6;
    @Column(name = "latitude7")
    private Double latitude7;
    @Column(name = "longitude7")
    private Double longitude7;
    @Column(name = "latitude8")
    private Double latitude8;
    @Column(name = "longitude8")
    private Double longitude8;
    @Column(name = "latitude9")
    private Double latitude9;
    @Column(name = "longitude9")
    private Double longitude9;
    @Column(name = "latitude10")
    private Double latitude10;
    @Column(name = "longitude10")
    private Double longitude10;
    @Column(name = "clientUpload")
    private Short clientUpload;
    @Column(name = "clientID")
    private Integer clientID;
    @Size(max = 32)
    @Column(name = "groupID")
    private String groupID;
    @Size(max = 90)
    @Column(name = "streetAddress")
    private String streetAddress;
    @Size(max = 40)
    @Column(name = "city")
    private String city;
    @Size(max = 40)
    @Column(name = "stateProvince")
    private String stateProvince;
    @Size(max = 16)
    @Column(name = "postalCode")
    private String postalCode;
    @Size(max = 40)
    @Column(name = "country")
    private String country;
    @Size(max = 32)
    @Column(name = "subdivision")
    private String subdivision;
    @Size(max = 32)
    @Column(name = "contactPhone")
    private String contactPhone;
    @Column(name = "isActive")
    private Short isActive;
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

    public Geozone() {
    }

    public Geozone(GeozonePK geozonePK) {
        this.geozonePK = geozonePK;
    }

    public Geozone(String accountID, String geozoneID, int sortID) {
        this.geozonePK = new GeozonePK(accountID, geozoneID, sortID);
    }

    public GeozonePK getGeozonePK() {
        return geozonePK;
    }

    public void setGeozonePK(GeozonePK geozonePK) {
        this.geozonePK = geozonePK;
    }

    public Double getMinLatitude() {
        return minLatitude;
    }

    public void setMinLatitude(Double minLatitude) {
        this.minLatitude = minLatitude;
    }

    public Double getMaxLatitude() {
        return maxLatitude;
    }

    public void setMaxLatitude(Double maxLatitude) {
        this.maxLatitude = maxLatitude;
    }

    public Double getMinLongitude() {
        return minLongitude;
    }

    public void setMinLongitude(Double minLongitude) {
        this.minLongitude = minLongitude;
    }

    public Double getMaxLongitude() {
        return maxLongitude;
    }

    public void setMaxLongitude(Double maxLongitude) {
        this.maxLongitude = maxLongitude;
    }

    public String getZonePurposeID() {
        return zonePurposeID;
    }

    public void setZonePurposeID(String zonePurposeID) {
        this.zonePurposeID = zonePurposeID;
    }

    public Short getReverseGeocode() {
        return reverseGeocode;
    }

    public void setReverseGeocode(Short reverseGeocode) {
        this.reverseGeocode = reverseGeocode;
    }

    public Short getArrivalZone() {
        return arrivalZone;
    }

    public void setArrivalZone(Short arrivalZone) {
        this.arrivalZone = arrivalZone;
    }

    public Integer getArrivalStatusCode() {
        return arrivalStatusCode;
    }

    public void setArrivalStatusCode(Integer arrivalStatusCode) {
        this.arrivalStatusCode = arrivalStatusCode;
    }

    public Short getDepartureZone() {
        return departureZone;
    }

    public void setDepartureZone(Short departureZone) {
        this.departureZone = departureZone;
    }

    public Integer getDepartureStatusCode() {
        return departureStatusCode;
    }

    public void setDepartureStatusCode(Integer departureStatusCode) {
        this.departureStatusCode = departureStatusCode;
    }

    public Short getAutoNotify() {
        return autoNotify;
    }

    public void setAutoNotify(Short autoNotify) {
        this.autoNotify = autoNotify;
    }

    public Short getZoomRegion() {
        return zoomRegion;
    }

    public void setZoomRegion(Short zoomRegion) {
        this.zoomRegion = zoomRegion;
    }

    public String getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public Short getZoneType() {
        return zoneType;
    }

    public void setZoneType(Short zoneType) {
        this.zoneType = zoneType;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public String getVertices() {
        return vertices;
    }

    public void setVertices(String vertices) {
        this.vertices = vertices;
    }

    public Double getLatitude1() {
        return latitude1;
    }

    public void setLatitude1(Double latitude1) {
        this.latitude1 = latitude1;
    }

    public Double getLongitude1() {
        return longitude1;
    }

    public void setLongitude1(Double longitude1) {
        this.longitude1 = longitude1;
    }

    public Double getLatitude2() {
        return latitude2;
    }

    public void setLatitude2(Double latitude2) {
        this.latitude2 = latitude2;
    }

    public Double getLongitude2() {
        return longitude2;
    }

    public void setLongitude2(Double longitude2) {
        this.longitude2 = longitude2;
    }

    public Double getLatitude3() {
        return latitude3;
    }

    public void setLatitude3(Double latitude3) {
        this.latitude3 = latitude3;
    }

    public Double getLongitude3() {
        return longitude3;
    }

    public void setLongitude3(Double longitude3) {
        this.longitude3 = longitude3;
    }

    public Double getLatitude4() {
        return latitude4;
    }

    public void setLatitude4(Double latitude4) {
        this.latitude4 = latitude4;
    }

    public Double getLongitude4() {
        return longitude4;
    }

    public void setLongitude4(Double longitude4) {
        this.longitude4 = longitude4;
    }

    public Double getLatitude5() {
        return latitude5;
    }

    public void setLatitude5(Double latitude5) {
        this.latitude5 = latitude5;
    }

    public Double getLongitude5() {
        return longitude5;
    }

    public void setLongitude5(Double longitude5) {
        this.longitude5 = longitude5;
    }

    public Double getLatitude6() {
        return latitude6;
    }

    public void setLatitude6(Double latitude6) {
        this.latitude6 = latitude6;
    }

    public Double getLongitude6() {
        return longitude6;
    }

    public void setLongitude6(Double longitude6) {
        this.longitude6 = longitude6;
    }

    public Double getLatitude7() {
        return latitude7;
    }

    public void setLatitude7(Double latitude7) {
        this.latitude7 = latitude7;
    }

    public Double getLongitude7() {
        return longitude7;
    }

    public void setLongitude7(Double longitude7) {
        this.longitude7 = longitude7;
    }

    public Double getLatitude8() {
        return latitude8;
    }

    public void setLatitude8(Double latitude8) {
        this.latitude8 = latitude8;
    }

    public Double getLongitude8() {
        return longitude8;
    }

    public void setLongitude8(Double longitude8) {
        this.longitude8 = longitude8;
    }

    public Double getLatitude9() {
        return latitude9;
    }

    public void setLatitude9(Double latitude9) {
        this.latitude9 = latitude9;
    }

    public Double getLongitude9() {
        return longitude9;
    }

    public void setLongitude9(Double longitude9) {
        this.longitude9 = longitude9;
    }

    public Double getLatitude10() {
        return latitude10;
    }

    public void setLatitude10(Double latitude10) {
        this.latitude10 = latitude10;
    }

    public Double getLongitude10() {
        return longitude10;
    }

    public void setLongitude10(Double longitude10) {
        this.longitude10 = longitude10;
    }

    public Short getClientUpload() {
        return clientUpload;
    }

    public void setClientUpload(Short clientUpload) {
        this.clientUpload = clientUpload;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
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
        hash += (geozonePK != null ? geozonePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Geozone)) {
            return false;
        }
        Geozone other = (Geozone) object;
        if ((this.geozonePK == null && other.geozonePK != null) || (this.geozonePK != null && !this.geozonePK.equals(other.geozonePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.Geozone[ geozonePK=" + geozonePK + " ]";
    }
    
}
