/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Roomtype;
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

    @Override
    public List<Roomtype> findByPeople(int people) {
        em = getEntityManager();
        try{
            Query query = em.createNamedQuery("Roomtype.findByMaxPeople");
            query.setParameter("maxPeople", people);
            return query.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
}
