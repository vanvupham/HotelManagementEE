/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Customer;
import entity.Reservation;
import entity.Room;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class ReservationManagedBean {
    private Reservation reservation;
    private String message;
    /**
     * Creates a new instance of ReservationManagedBean
     */
    public ReservationManagedBean() {
        reservation = new Reservation();
    }

    public Integer getReservationId() {
        return reservation.getReservationId();
    }

    public void setReservationId(Integer reservationId) {
        reservation.setReservationId(reservationId);
    }

    public String getCustomerList() {
        return reservation.getCustomerList();
    }

    public void setCustomerList(String customerList) {
        reservation.setCustomerList(customerList);
    }

    public int getNumberOfPeople() {
        return reservation.getNumberOfPeople();
    }

    public void setNumberOfPeople(int numberOfPeople) {
        reservation.setNumberOfPeople(numberOfPeople);
    }

    public Date getDateIn() {
        return reservation.getDateIn();
    }

    public void setDateIn(Date dateIn) {
        reservation.setDateIn(dateIn);
    }

    public Date getDateOut() {
        return reservation.getDateOut();
    }

    public void setDateOut(Date dateOut) {
        reservation.setDateOut(dateOut);
    }

    public Date getBookingDate() {
        return reservation.getBookingDate();
    }

    public void setBookingDate(Date bookingDate) {
        reservation.setBookingDate(bookingDate);
    }

    public Customer getCustomerId() {
        return reservation.getCustomerId();
    }

    public void setCustomerId(Customer customerId) {
        reservation.setCustomerId(customerId);
    }

    public Room getRoomId() {
        return reservation.getRoomId();
    }

    public void setRoomId(Room roomId) {
        reservation.setRoomId(roomId);
    }


    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
