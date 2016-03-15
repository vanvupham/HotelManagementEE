/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Room;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Willi
 */
@Local
public interface RoomFacadeLocal {

    void create(Room room);

    void edit(Room room);

    void remove(Room room);

    Room find(Object id);

    List<Room> findAll();

    List<Room> findRange(int[] range);
    
    List<Room> findByRoomTypeId(int typeId);

    int count();
    
}
