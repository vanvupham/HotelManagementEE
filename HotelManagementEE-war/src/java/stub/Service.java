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
import session.ServiceFacadeLocal;

/**
 *
 * @author Willi
 */
public class Service {
    ServiceFacadeLocal serviceFacade = lookupServiceFacadeLocal();

    private ServiceFacadeLocal lookupServiceFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (ServiceFacadeLocal) c.lookup("java:global/HotelManagementEE/HotelManagementEE-ejb/ServiceFacade!session.ServiceFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(entity.Service service) {
        serviceFacade.create(service);
    }

    public void edit(entity.Service service) {
        serviceFacade.edit(service);
    }

    public void remove(entity.Service service) {
        serviceFacade.remove(service);
    }

    public entity.Service find(Object id) {
        return serviceFacade.find(id);
    }

    public List<entity.Service> findAll() {
        return serviceFacade.findAll();
    }

    public List<entity.Service> findRange(int[] range) {
        return serviceFacade.findRange(range);
    }

    public int count() {
        return serviceFacade.count();
    }
    
}
