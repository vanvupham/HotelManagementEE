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
import session.PromotionFacadeLocal;

/**
 *
 * @author Willi
 */
public class Promotion {
    PromotionFacadeLocal promotionFacade = lookupPromotionFacadeLocal();

    private PromotionFacadeLocal lookupPromotionFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (PromotionFacadeLocal) c.lookup("java:global/HotelManagementEE/HotelManagementEE-ejb/PromotionFacade!session.PromotionFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(entity.Promotion promotion) {
        promotionFacade.create(promotion);
    }

    public void edit(entity.Promotion promotion) {
        promotionFacade.edit(promotion);
    }

    public void remove(entity.Promotion promotion) {
        promotionFacade.remove(promotion);
    }

    public entity.Promotion find(Object id) {
        return promotionFacade.find(id);
    }

    public List<entity.Promotion> findAll() {
        return promotionFacade.findAll();
    }

    public List<entity.Promotion> findRange(int[] range) {
        return promotionFacade.findRange(range);
    }

    public int count() {
        return promotionFacade.count();
    }
    
}
