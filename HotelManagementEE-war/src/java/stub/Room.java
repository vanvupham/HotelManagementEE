/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.RoomFacadeLocal;

/**
 *
 * @author Willi
 */
public class Room {
    RoomFacadeLocal roomFacade = lookupRoomFacadeLocal();

    private RoomFacadeLocal lookupRoomFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (RoomFacadeLocal) c.lookup("java:global/HotelManagementEE/HotelManagementEE-ejb/RoomFacade!session.RoomFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(entity.Room room) {
        roomFacade.create(room);
    }

    public void edit(entity.Room room) {
        roomFacade.edit(room);
    }

    public void remove(entity.Room room) {
        roomFacade.remove(room);
    }

    public entity.Room find(Object id) {
        return roomFacade.find(id);
    }

    public List<entity.Room> findAll() {
        return roomFacade.findAll();
    }

    public List<entity.Room> findRange(int[] range) {
        return roomFacade.findRange(range);
    }

    public int count() {
        return roomFacade.count();
    }
    
}
