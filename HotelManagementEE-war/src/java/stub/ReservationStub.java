/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Reservation;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.ReservationFacadeLocal;

/**
 *
 * @author Willi
 */
public class ReservationStub {
    ReservationFacadeLocal reservationFacade = lookupReservationFacadeLocal();

    private ReservationFacadeLocal lookupReservationFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (ReservationFacadeLocal) c.lookup("java:global/HotelManagementEE/HotelManagementEE-ejb/ReservationFacade!session.ReservationFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(entity.Reservation reservation) {
        reservationFacade.create(reservation);
    }

    public void edit(entity.Reservation reservation) {
        reservationFacade.edit(reservation);
    }

    public void remove(entity.Reservation reservation) {
        reservationFacade.remove(reservation);
    }

    public entity.Reservation find(Object id) {
        return reservationFacade.find(id);
    }

    public List<entity.Reservation> findAll() {
        return reservationFacade.findAll();
    }

    public List<entity.Reservation> findRange(int[] range) {
        return reservationFacade.findRange(range);
    }

    public int count() {
        return reservationFacade.count();
    }

    public List<Reservation> findByRoomId(int roomid) {
        return reservationFacade.findByRoomId(roomid);
    }
    
}
