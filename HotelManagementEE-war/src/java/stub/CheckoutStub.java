/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Checkout;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.CheckoutFacadeLocal;

/**
 *
 * @author Willi
 */
public class CheckoutStub {
    CheckoutFacadeLocal checkoutFacade = lookupCheckoutFacadeLocal();

    private CheckoutFacadeLocal lookupCheckoutFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (CheckoutFacadeLocal) c.lookup("java:global/HotelManagementEE/HotelManagementEE-ejb/CheckoutFacade!session.CheckoutFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Checkout checkout) {
        checkoutFacade.create(checkout);
    }

    public void edit(Checkout checkout) {
        checkoutFacade.edit(checkout);
    }

    public void remove(Checkout checkout) {
        checkoutFacade.remove(checkout);
    }

    public Checkout find(Object id) {
        return checkoutFacade.find(id);
    }

    public List<Checkout> findAll() {
        return checkoutFacade.findAll();
    }

    public List<Checkout> findRange(int[] range) {
        return checkoutFacade.findRange(range);
    }

    public int count() {
        return checkoutFacade.count();
    }
    
}
