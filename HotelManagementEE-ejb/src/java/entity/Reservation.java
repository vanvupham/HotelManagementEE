/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Willi
 */
@Entity
@Table(name = "reservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
    @NamedQuery(name = "Reservation.findByReservationId", query = "SELECT r FROM Reservation r WHERE r.reservationId = :reservationId"),
    @NamedQuery(name = "Reservation.findByCustomerList", query = "SELECT r FROM Reservation r WHERE r.customerList = :customerList"),
    @NamedQuery(name = "Reservation.findByNumberOfPeople", query = "SELECT r FROM Reservation r WHERE r.numberOfPeople = :numberOfPeople"),
    @NamedQuery(name = "Reservation.findByDateIn", query = "SELECT r FROM Reservation r WHERE r.dateIn = :dateIn"),
    @NamedQuery(name = "Reservation.findByDateOut", query = "SELECT r FROM Reservation r WHERE r.dateOut = :dateOut"),
    @NamedQuery(name = "Reservation.findByRoomId", query = "SELECT r FROM Reservation r WHERE r.roomId = :roomId"),
    @NamedQuery(name = "Reservation.findByBookingDate", query = "SELECT r FROM Reservation r WHERE r.bookingDate = :bookingDate")})
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reservationId")
    private Integer reservationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "customerList")
    private String customerList;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numberOfPeople")
    private int numberOfPeople;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateIn")
    @Temporal(TemporalType.DATE)
    private Date dateIn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateOut")
    @Temporal(TemporalType.DATE)
    private Date dateOut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bookingDate")
    @Temporal(TemporalType.DATE)
    private Date bookingDate;
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    @ManyToOne(optional = false)
    private Customer customerId;
    @JoinColumn(name = "roomId", referencedColumnName = "roomId")
    @ManyToOne(optional = false)
    private Room roomId;

    public Reservation() {
    }

    public Reservation(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Reservation(Integer reservationId, String customerList, int numberOfPeople, Date dateIn, Date dateOut, Date bookingDate) {
        this.reservationId = reservationId;
        this.customerList = customerList;
        this.numberOfPeople = numberOfPeople;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.bookingDate = bookingDate;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public String getCustomerList() {
        return customerList;
    }

    public void setCustomerList(String customerList) {
        this.customerList = customerList;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationId != null ? reservationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.reservationId == null && other.reservationId != null) || (this.reservationId != null && !this.reservationId.equals(other.reservationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Reservation[ reservationId=" + reservationId + " ]";
    }
    
}
