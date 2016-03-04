/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Checkin;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.CheckinFacadeLocal;

/**
 *
 * @author Willi
 */
public class CheckinStub {
    CheckinFacadeLocal checkinFacade = lookupCheckinFacadeLocal();

    private CheckinFacadeLocal lookupCheckinFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (CheckinFacadeLocal) c.lookup("java:global/HotelManagementEE/HotelManagementEE-ejb/CheckinFacade!session.CheckinFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Checkin checkin) {
        checkinFacade.create(checkin);
    }

    public void edit(Checkin checkin) {
        checkinFacade.edit(checkin);
    }

    public void remove(Checkin checkin) {
        checkinFacade.remove(checkin);
    }

    public Checkin find(Object id) {
        return checkinFacade.find(id);
    }

    public List<Checkin> findAll() {
        return checkinFacade.findAll();
    }

    public List<Checkin> findRange(int[] range) {
        return checkinFacade.findRange(range);
    }

    public int count() {
        return checkinFacade.count();
    }
    
}
