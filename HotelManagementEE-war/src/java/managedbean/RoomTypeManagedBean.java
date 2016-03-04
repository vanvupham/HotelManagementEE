/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Roomtype;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import stub.RoomType;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class RoomTypeManagedBean {
    private RoomType roomType;
    private String message;
    /**
     * Creates a new instance of RoomTypeManagedBean
     */
    public RoomTypeManagedBean() {
    }

    public void create(Roomtype roomtype) {
        roomType.create(roomtype);
    }

    public void edit(Roomtype roomtype) {
        roomType.edit(roomtype);
    }

    public void remove(Roomtype roomtype) {
        roomType.remove(roomtype);
    }

    public Roomtype find(Object id) {
        return roomType.find(id);
    }

    public List<Roomtype> findAll() {
        return roomType.findAll();
    }

    public List<Roomtype> findRange(int[] range) {
        return roomType.findRange(range);
    }

    public int count() {
        return roomType.count();
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
