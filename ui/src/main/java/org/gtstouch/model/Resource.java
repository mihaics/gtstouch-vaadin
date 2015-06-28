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
@Table(name = "Resource")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resource.findAll", query = "SELECT r FROM Resource r"),
    @NamedQuery(name = "Resource.findByAccountID", query = "SELECT r FROM Resource r WHERE r.resourcePK.accountID = :accountID"),
    @NamedQuery(name = "Resource.findByResourceID", query = "SELECT r FROM Resource r WHERE r.resourcePK.resourceID = :resourceID"),
    @NamedQuery(name = "Resource.findByType", query = "SELECT r FROM Resource r WHERE r.type = :type"),
    @NamedQuery(name = "Resource.findByTitle", query = "SELECT r FROM Resource r WHERE r.title = :title"),
    @NamedQuery(name = "Resource.findByDisplayName", query = "SELECT r FROM Resource r WHERE r.displayName = :displayName"),
    @NamedQuery(name = "Resource.findByDescription", query = "SELECT r FROM Resource r WHERE r.description = :description"),
    @NamedQuery(name = "Resource.findByLastUpdateTime", query = "SELECT r FROM Resource r WHERE r.lastUpdateTime = :lastUpdateTime"),
    @NamedQuery(name = "Resource.findByCreationTime", query = "SELECT r FROM Resource r WHERE r.creationTime = :creationTime")})
public class Resource implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResourcePK resourcePK;
    @Size(max = 16)
    @Column(name = "type")
    private String type;
    @Size(max = 70)
    @Column(name = "title")
    private String title;
    @Lob
    @Size(max = 65535)
    @Column(name = "properties")
    private String properties;
    @Lob
    @Column(name = "value")
    private byte[] value;
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

    public Resource() {
    }

    public Resource(ResourcePK resourcePK) {
        this.resourcePK = resourcePK;
    }

    public Resource(String accountID, String resourceID) {
        this.resourcePK = new ResourcePK(accountID, resourceID);
    }

    public ResourcePK getResourcePK() {
        return resourcePK;
    }

    public void setResourcePK(ResourcePK resourcePK) {
        this.resourcePK = resourcePK;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public byte[] getValue() {
        return value;
    }

    public void setValue(byte[] value) {
        this.value = value;
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
        hash += (resourcePK != null ? resourcePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resource)) {
            return false;
        }
        Resource other = (Resource) object;
        if ((this.resourcePK == null && other.resourcePK != null) || (this.resourcePK != null && !this.resourcePK.equals(other.resourcePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.Resource[ resourcePK=" + resourcePK + " ]";
    }
    
}
