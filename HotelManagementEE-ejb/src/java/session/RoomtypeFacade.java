/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Roomtype;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Willi
 */
@Stateless
public class RoomtypeFacade extends AbstractFacade<Roomtype> implements RoomtypeFacadeLocal {
    @PersistenceContext(unitName = "HotelManagementEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoomtypeFacade() {
        super(Roomtype.class);
    }
    
}
