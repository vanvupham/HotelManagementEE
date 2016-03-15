/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Room;
import entity.Roomtype;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import stub.RoomStub;
import stub.RoomTypeStub;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class RoomManagedBean {

    private Room room;
    private int typeId;
    private List<Room> listRoomByRoomTypeId,listAllRoom,listRoomEmpty;
    private List<Roomtype> listRoomTypeByPeople;
    
    private int person;

    /**
     * Creates a new instance of RoomManagedBean
     */
    public RoomManagedBean() {
        room = new Room();
        listRoomByRoomTypeId = new ArrayList<Room>();
        listAllRoom = new ArrayList<Room>();
        listRoomTypeByPeople = new ArrayList<Roomtype>();
        listRoomEmpty = new ArrayList<Room>();
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

    public Roomtype getRoomTypeId() {
        return room.getRoomTypeId();
    }

    public void setRoomTypeId(Roomtype roomTypeId) {
        room.setRoomTypeId(roomTypeId);
    }

    public List<Room> getListRoomByRoomTypeId() {
        return listRoomByRoomTypeId;
    }

    public void setListRoomByRoomTypeId(List<Room> listRoomByRoomTypeId) {
        this.listRoomByRoomTypeId = listRoomByRoomTypeId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }
    
    public List<Room> findRoomByRoomTypeId(){
        try{
            RoomStub roomStub = new RoomStub();
            RoomTypeStub roomtypeStub = new RoomTypeStub();
            listAllRoom = roomStub.findAll();
            listRoomTypeByPeople = roomtypeStub.findByPeople(getPerson());
            for(Roomtype roomType : listRoomTypeByPeople){
                for(Room room : listAllRoom){
                    if(room.getRoomTypeId().getRoomtypeId() == roomType.getRoomtypeId()){
                        listRoomByRoomTypeId.add(room);
                    }
                }
            }
            return listRoomByRoomTypeId;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
//    public List<Room> findRoomByRoomTypeId() {
//        try {
//            RoomStub roomStub = new RoomStub();
//            RoomTypeStub roomtypeStub = new RoomTypeStub();
//            listRoomTypeByPeople = roomtypeStub.findByPeople(getPerson());
//            for(Roomtype type : listRoomTypeByPeople){
//            listRoomByRoomTypeId = roomStub.findByRoomTypeId(type.getRoomtypeId());
//            }
//            return listRoomByRoomTypeId;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
}
