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
@Table(name = "StatusCode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusCode.findAll", query = "SELECT s FROM StatusCode s"),
    @NamedQuery(name = "StatusCode.findByAccountID", query = "SELECT s FROM StatusCode s WHERE s.statusCodePK.accountID = :accountID"),
    @NamedQuery(name = "StatusCode.findByDeviceID", query = "SELECT s FROM StatusCode s WHERE s.statusCodePK.deviceID = :deviceID"),
    @NamedQuery(name = "StatusCode.findByStatusCode", query = "SELECT s FROM StatusCode s WHERE s.statusCodePK.statusCode = :statusCode"),
    @NamedQuery(name = "StatusCode.findByStatusName", query = "SELECT s FROM StatusCode s WHERE s.statusName = :statusName"),
    @NamedQuery(name = "StatusCode.findByForegroundColor", query = "SELECT s FROM StatusCode s WHERE s.foregroundColor = :foregroundColor"),
    @NamedQuery(name = "StatusCode.findByBackgroundColor", query = "SELECT s FROM StatusCode s WHERE s.backgroundColor = :backgroundColor"),
    @NamedQuery(name = "StatusCode.findByIconSelector", query = "SELECT s FROM StatusCode s WHERE s.iconSelector = :iconSelector"),
    @NamedQuery(name = "StatusCode.findByIconName", query = "SELECT s FROM StatusCode s WHERE s.iconName = :iconName"),
    @NamedQuery(name = "StatusCode.findByDescription", query = "SELECT s FROM StatusCode s WHERE s.description = :description"),
    @NamedQuery(name = "StatusCode.findByLastUpdateTime", query = "SELECT s FROM StatusCode s WHERE s.lastUpdateTime = :lastUpdateTime"),
    @NamedQuery(name = "StatusCode.findByCreationTime", query = "SELECT s FROM StatusCode s WHERE s.creationTime = :creationTime")})
public class StatusCode implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StatusCodePK statusCodePK;
    @Size(max = 18)
    @Column(name = "statusName")
    private String statusName;
    @Size(max = 10)
    @Column(name = "foregroundColor")
    private String foregroundColor;
    @Size(max = 10)
    @Column(name = "backgroundColor")
    private String backgroundColor;
    @Size(max = 128)
    @Column(name = "iconSelector")
    private String iconSelector;
    @Size(max = 24)
    @Column(name = "iconName")
    private String iconName;
    @Size(max = 128)
    @Column(name = "description")
    private String description;
    @Column(name = "lastUpdateTime")
    private Integer lastUpdateTime;
    @Column(name = "creationTime")
    private Integer creationTime;

    public StatusCode() {
    }

    public StatusCode(StatusCodePK statusCodePK) {
        this.statusCodePK = statusCodePK;
    }

    public StatusCode(String accountID, String deviceID, int statusCode) {
        this.statusCodePK = new StatusCodePK(accountID, deviceID, statusCode);
    }

    public StatusCodePK getStatusCodePK() {
        return statusCodePK;
    }

    public void setStatusCodePK(StatusCodePK statusCodePK) {
        this.statusCodePK = statusCodePK;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(String foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getIconSelector() {
        return iconSelector;
    }

    public void setIconSelector(String iconSelector) {
        this.iconSelector = iconSelector;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
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
        hash += (statusCodePK != null ? statusCodePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusCode)) {
            return false;
        }
        StatusCode other = (StatusCode) object;
        if ((this.statusCodePK == null && other.statusCodePK != null) || (this.statusCodePK != null && !this.statusCodePK.equals(other.statusCodePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.StatusCode[ statusCodePK=" + statusCodePK + " ]";
    }
    
}
