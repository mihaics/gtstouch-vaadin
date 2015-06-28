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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mihai
 */
@Entity
@Table(name = "PendingPacket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PendingPacket.findAll", query = "SELECT p FROM PendingPacket p"),
    @NamedQuery(name = "PendingPacket.findByAccountID", query = "SELECT p FROM PendingPacket p WHERE p.pendingPacketPK.accountID = :accountID"),
    @NamedQuery(name = "PendingPacket.findByDeviceID", query = "SELECT p FROM PendingPacket p WHERE p.pendingPacketPK.deviceID = :deviceID"),
    @NamedQuery(name = "PendingPacket.findByQueueTime", query = "SELECT p FROM PendingPacket p WHERE p.pendingPacketPK.queueTime = :queueTime"),
    @NamedQuery(name = "PendingPacket.findBySequence", query = "SELECT p FROM PendingPacket p WHERE p.pendingPacketPK.sequence = :sequence"),
    @NamedQuery(name = "PendingPacket.findByAutoDelete", query = "SELECT p FROM PendingPacket p WHERE p.autoDelete = :autoDelete")})
public class PendingPacket implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PendingPacketPK pendingPacketPK;
    @Lob
    @Column(name = "packetBytes")
    private byte[] packetBytes;
    @Column(name = "autoDelete")
    private Short autoDelete;

    public PendingPacket() {
    }

    public PendingPacket(PendingPacketPK pendingPacketPK) {
        this.pendingPacketPK = pendingPacketPK;
    }

    public PendingPacket(String accountID, String deviceID, int queueTime, short sequence) {
        this.pendingPacketPK = new PendingPacketPK(accountID, deviceID, queueTime, sequence);
    }

    public PendingPacketPK getPendingPacketPK() {
        return pendingPacketPK;
    }

    public void setPendingPacketPK(PendingPacketPK pendingPacketPK) {
        this.pendingPacketPK = pendingPacketPK;
    }

    public byte[] getPacketBytes() {
        return packetBytes;
    }

    public void setPacketBytes(byte[] packetBytes) {
        this.packetBytes = packetBytes;
    }

    public Short getAutoDelete() {
        return autoDelete;
    }

    public void setAutoDelete(Short autoDelete) {
        this.autoDelete = autoDelete;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pendingPacketPK != null ? pendingPacketPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PendingPacket)) {
            return false;
        }
        PendingPacket other = (PendingPacket) object;
        if ((this.pendingPacketPK == null && other.pendingPacketPK != null) || (this.pendingPacketPK != null && !this.pendingPacketPK.equals(other.pendingPacketPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.gtstouch.model.PendingPacket[ pendingPacketPK=" + pendingPacketPK + " ]";
    }
    
}
