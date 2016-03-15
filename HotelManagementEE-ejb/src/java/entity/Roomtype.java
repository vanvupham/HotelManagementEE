/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Willi
 */
@Entity
@Table(name = "roomtype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roomtype.findAll", query = "SELECT r FROM Roomtype r"),
    @NamedQuery(name = "Roomtype.findByRoomtypeId", query = "SELECT r FROM Roomtype r WHERE r.roomtypeId = :roomtypeId"),
    @NamedQuery(name = "Roomtype.findByRoomtypeName", query = "SELECT r FROM Roomtype r WHERE r.roomtypeName = :roomtypeName"),
    @NamedQuery(name = "Roomtype.findByMaxPeople", query = "SELECT r FROM Roomtype r WHERE r.maxPeople >= :maxPeople"),    
    @NamedQuery(name = "Roomtype.findByPrice", query = "SELECT r FROM Roomtype r WHERE r.price = :price")})
public class Roomtype implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "maxPeople")
    private int maxPeople;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "roomtypeId")
    private Integer roomtypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "roomtypeName")
    private String roomtypeName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomTypeId")
    private List<Room> roomList;

    public Roomtype() {
    }

    public Roomtype(Integer roomtypeId) {
        this.roomtypeId = roomtypeId;
    }

    public Roomtype(Integer roomtypeId, String roomtypeName, BigDecimal price) {
        this.roomtypeId = roomtypeId;
        this.roomtypeName = roomtypeName;
        this.price = price;
    }

    public Integer getRoomtypeId() {
        return roomtypeId;
    }

    public void setRoomtypeId(Integer roomtypeId) {
        this.roomtypeId = roomtypeId;
    }

    public String getRoomtypeName() {
        return roomtypeName;
    }

    public void setRoomtypeName(String roomtypeName) {
        this.roomtypeName = roomtypeName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @XmlTransient
    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomtypeId != null ? roomtypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roomtype)) {
            return false;
        }
        Roomtype other = (Roomtype) object;
        if ((this.roomtypeId == null && other.roomtypeId != null) || (this.roomtypeId != null && !this.roomtypeId.equals(other.roomtypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Roomtype[ roomtypeId=" + roomtypeId + " ]";
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }
    
}
