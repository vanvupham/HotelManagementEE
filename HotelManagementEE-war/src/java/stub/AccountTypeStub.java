/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Accounttype;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.AccounttypeFacadeLocal;

/**
 *
 * @author Willi
 */
public class AccountTypeStub {
    AccounttypeFacadeLocal accounttypeFacade = lookupAccounttypeFacadeLocal();

    private AccounttypeFacadeLocal lookupAccounttypeFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (AccounttypeFacadeLocal) c.lookup("java:global/HotelManagementEE/HotelManagementEE-ejb/AccounttypeFacade!session.AccounttypeFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Accounttype accounttype) {
        accounttypeFacade.create(accounttype);
    }

    public void edit(Accounttype accounttype) {
        accounttypeFacade.edit(accounttype);
    }

    public void remove(Accounttype accounttype) {
        accounttypeFacade.remove(accounttype);
    }

    public Accounttype find(Object id) {
        return accounttypeFacade.find(id);
    }

    public List<Accounttype> findAll() {
        return accounttypeFacade.findAll();
    }

    public List<Accounttype> findRange(int[] range) {
        return accounttypeFacade.findRange(range);
    }

    public int count() {
        return accounttypeFacade.count();
    }
    
}
