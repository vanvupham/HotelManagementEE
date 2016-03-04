/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Usedservice;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Willi
 */
@Local
public interface UsedserviceFacadeLocal {

    void create(Usedservice usedservice);

    void edit(Usedservice usedservice);

    void remove(Usedservice usedservice);

    Usedservice find(Object id);

    List<Usedservice> findAll();

    List<Usedservice> findRange(int[] range);

    int count();
    
}
