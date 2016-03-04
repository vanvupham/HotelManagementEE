/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Checkin;
import entity.Reservation;
import entity.Room;
import entity.Roomtype;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class RoomManagedBean {
    private Room room;
    private String message;
    /**
     * Creates a new instance of RoomManagedBean
     */
    public RoomManagedBean() {
    }

    public Integer getRoomId() {
        return room.getRoomId();
    }

    public void setRoomId(Integer roomId) {
        room.setRoomId(roomId);
    }

    public String getRoomName() {
        return room.getRoomName();
    }

    public void setRoomName(String roomName) {
        room.setRoomName(roomName);
    }

    public int getNumberOfBed() {
        return room.getNumberOfBed();
    }

    public void setNumberOfBed(int numberOfBed) {
        room.setNumberOfBed(numberOfBed);
    }

    public String getRoomPhone() {
        return room.getRoomPhone();
    }

    public void setRoomPhone(String roomPhone) {
        room.setRoomPhone(roomPhone);
    }

    public String getDescription() {
        return room.getDescription();
    }

    public void setDescription(String description) {
        room.setDescription(description);
    }

    public String getStatus() {
        return room.getStatus();
    }

    public void setStatus(String status) {
        room.setStatus(status);
    }

    public List<Checkin> getCheckinList() {
        return room.getCheckinList();
    }

    public void setCheckinList(List<Checkin> checkinList) {
        room.setCheckinList(checkinList);
    }

    public List<Reservation> getReservationList() {
        return room.getReservationList();
    }

    public void setReservationList(List<Reservation> reservationList) {
        room.setReservationList(reservationList);
    }

    public Roomtype getRoomTypeId() {
        return room.getRoomTypeId();
    }

    public void setRoomTypeId(Roomtype roomTypeId) {
        room.setRoomTypeId(roomTypeId);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
}
