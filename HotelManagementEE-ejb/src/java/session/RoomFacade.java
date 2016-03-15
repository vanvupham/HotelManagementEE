/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Room;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Willi
 */
@Stateless
public class RoomFacade extends AbstractFacade<Room> implements RoomFacadeLocal {

    @PersistenceContext(unitName = "HotelManagementEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoomFacade() {
        super(Room.class);
    }

    @Override
    public List<Room> findByRoomTypeId(int typeId) {
        em = getEntityManager();
        try{
            Query query = em.createNamedQuery("Room.findByRoomTypeId");
            query.setParameter("roomTypeId", typeId);
            return query.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }


}
