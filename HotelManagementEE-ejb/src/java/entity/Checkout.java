/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Willi
 */
@Entity
@Table(name = "checkout")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checkout.findAll", query = "SELECT c FROM Checkout c"),
    @NamedQuery(name = "Checkout.findByCheckOutId", query = "SELECT c FROM Checkout c WHERE c.checkOutId = :checkOutId")})
public class Checkout implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "checkOutId")
    private Integer checkOutId;
    @JoinColumn(name = "checkInId", referencedColumnName = "checkinId")
    @ManyToOne(optional = false)
    private Checkin checkInId;
    @JoinColumn(name = "userServiceId", referencedColumnName = "usedServiceId")
    @ManyToOne(optional = false)
    private Usedservice userServiceId;

    public Checkout() {
    }

    public Checkout(Integer checkOutId) {
        this.checkOutId = checkOutId;
    }

    public Integer getCheckOutId() {
        return checkOutId;
    }

    public void setCheckOutId(Integer checkOutId) {
        this.checkOutId = checkOutId;
    }

    public Checkin getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(Checkin checkInId) {
        this.checkInId = checkInId;
    }

    public Usedservice getUserServiceId() {
        return userServiceId;
    }

    public void setUserServiceId(Usedservice userServiceId) {
        this.userServiceId = userServiceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checkOutId != null ? checkOutId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Checkout)) {
            return false;
        }
        Checkout other = (Checkout) object;
        if ((this.checkOutId == null && other.checkOutId != null) || (this.checkOutId != null && !this.checkOutId.equals(other.checkOutId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Checkout[ checkOutId=" + checkOutId + " ]";
    }
    
}
