/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Checkout;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Willi
 */
@Local
public interface CheckoutFacadeLocal {

    void create(Checkout checkout);

    void edit(Checkout checkout);

    void remove(Checkout checkout);

    Checkout find(Object id);

    List<Checkout> findAll();

    List<Checkout> findRange(int[] range);

    int count();
    
}
