/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Customer;
import entity.Reservation;
import entity.Room;
import entity.Roomtype;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import stub.ReservationStub;
import stub.RoomStub;
import stub.RoomTypeStub;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class ReservationManagedBean {

    private Reservation reservation;
    private List<Reservation> listReservation;
    private List<Room> listRoomByRoomTypeId, listAllRoom;
    private List<Room> listRoomWaiting, listRoomBusy, listRoomEmpty;
    private List<Roomtype> listRoomTypeByPeople;
    private int person;
    private Date start,end;
    private int id;
    private int roomsSuite , roomsStudio , roomsKing , roomExecutive , 
                roomsDeluxeKing , roomsDouble;

    /**
     * Creates a new instance of ReservationManagedBean
     */
    public ReservationManagedBean() {
        reservation = new Reservation();
        listReservation = new ArrayList<Reservation>();
        listRoomByRoomTypeId = new ArrayList<Room>();
        listAllRoom = new ArrayList<Room>();
        listRoomTypeByPeople = new ArrayList<Roomtype>();
        listRoomEmpty = new ArrayList<Room>();
        listRoomWaiting = new ArrayList<Room>();
        listRoomBusy = new ArrayList<Room>();
        roomExecutive = 0;
        roomsKing = 0;
        roomsDeluxeKing = 0;
        roomsDouble = 0;
        roomsStudio = 0;
        roomsSuite = 0;
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

    public List<Reservation> getListReservation() {
        return listReservation;
    }

    public void setListReservation(List<Reservation> listReservation) {
        this.listReservation = listReservation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public List<Room> getListRoomEmpty() {
        return listRoomEmpty;
    }

    public void setListRoomEmpty(List<Room> listRoomEmpty) {
        this.listRoomEmpty = listRoomEmpty;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getRoomsSuite() {
        return roomsSuite;
    }

    public void setRoomsSuite(int roomsSuite) {
        this.roomsSuite = roomsSuite;
    }

    public int getRoomsStudio() {
        return roomsStudio;
    }

    public void setRoomsStudio(int roomsStudio) {
        this.roomsStudio = roomsStudio;
    }

    public int getRoomsKing() {
        return roomsKing;
    }

    public void setRoomsKing(int roomsKing) {
        this.roomsKing = roomsKing;
    }

    public int getRoomExecutive() {
        return roomExecutive;
    }

    public void setRoomExecutive(int roomExecutive) {
        this.roomExecutive = roomExecutive;
    }

    public int getRoomsDeluxeKing() {
        return roomsDeluxeKing;
    }

    public void setRoomsDeluxeKing(int roomsDeluxeKing) {
        this.roomsDeluxeKing = roomsDeluxeKing;
    }

    public int getRoomsDouble() {
        return roomsDouble;
    }

    public void setRoomsDouble(int roomsDouble) {
        this.roomsDouble = roomsDouble;
    }
    
    public String findRoomForReservation(Date start, Date end) {
        try {
            RoomStub roomStub = new RoomStub();
            RoomTypeStub roomtypeStub = new RoomTypeStub();
            ReservationStub reservationStub = new ReservationStub();
            //get all room
            listAllRoom = roomStub.findAll();
            //get all reservation
            listReservation = reservationStub.findAll();
            //get roomtypeid by people
            listRoomTypeByPeople = roomtypeStub.findByPeople(getPerson());
            //get Room by roomtypeid
            for (Roomtype roomType : listRoomTypeByPeople) {
                for (Room room : listAllRoom) {
                    if (room.getRoomTypeId().getRoomtypeId() == roomType.getRoomtypeId()) {
                        listRoomByRoomTypeId.add(room);
                    }
                }
            }
            //check room status
            for (Room room : listRoomByRoomTypeId) {
                if (room.getStatus().equalsIgnoreCase("E")) {
                    listRoomEmpty.add(room);
                }
                if (room.getStatus().equalsIgnoreCase("W")) {
                    listRoomWaiting.add(room);
                }
                if (room.getStatus().equalsIgnoreCase("B")) {
                    listRoomBusy.add(room);
                }
            }
            //get Resvercation by RoomWaittingId
            for (Room room : listRoomWaiting) {
                for (Reservation resvervation : listReservation) {
                    if (resvervation.getRoomId().getRoomId() == room.getRoomId()) {
                        if (resvervation.getDateOut().before(start)) {
                            listRoomEmpty.add(room);
                            continue;
                        }
                        if (resvervation.getDateIn().after(end)) {
                            listRoomEmpty.add(room);
                            continue;
                        }
                    }
                }
            }
            for(Room room : listRoomEmpty){
                if(room.getRoomTypeId().getRoomtypeId()==1){
                    roomsSuite++;
                }
                if(room.getRoomTypeId().getRoomtypeId()==2){
                    roomsStudio++;
                }
                if(room.getRoomTypeId().getRoomtypeId()==3){
                    roomsKing++;
                }
                if(room.getRoomTypeId().getRoomtypeId()==4){
                    roomExecutive++;
                }
                if(room.getRoomTypeId().getRoomtypeId()==5){
                    roomsDeluxeKing++;
                }
                if(room.getRoomTypeId().getRoomtypeId()==6){
                    roomsDouble++;
                }
            }
            return "bookingroom";
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
