/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Account;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Willi
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeLocal {
    @PersistenceContext(unitName = "HotelManagementEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }

    @Override
    public Account findUserName(String username) {
        em = getEntityManager();
        try{
            Query query = em.createNamedQuery("Account.findByUsername");
            query.setParameter("username", username);
            return (Account) query.getSingleResult();
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Account findUserAndPass(String username, String password) {
        em = getEntityManager();
        try{
            Query query = em.createNamedQuery("Account.findByUserAndPass");
            query.setParameter("username", username);
            query.setParameter("password", password);
            return (Account) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
}
