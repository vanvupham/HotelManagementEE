/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Usedservice;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.UsedserviceFacadeLocal;

/**
 *
 * @author Willi
 */
public class UsedServiceStub {
    UsedserviceFacadeLocal usedserviceFacade = lookupUsedserviceFacadeLocal();

    private UsedserviceFacadeLocal lookupUsedserviceFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (UsedserviceFacadeLocal) c.lookup("java:global/HotelManagementEE/HotelManagementEE-ejb/UsedserviceFacade!session.UsedserviceFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Usedservice usedservice) {
        usedserviceFacade.create(usedservice);
    }

    public void edit(Usedservice usedservice) {
        usedserviceFacade.edit(usedservice);
    }

    public void remove(Usedservice usedservice) {
        usedserviceFacade.remove(usedservice);
    }

    public Usedservice find(Object id) {
        return usedserviceFacade.find(id);
    }

    public List<Usedservice> findAll() {
        return usedserviceFacade.findAll();
    }

    public List<Usedservice> findRange(int[] range) {
        return usedserviceFacade.findRange(range);
    }

    public int count() {
        return usedserviceFacade.count();
    }
    
}
