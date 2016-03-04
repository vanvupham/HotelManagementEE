/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Accounttype;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Willi
 */
@Local
public interface AccounttypeFacadeLocal {

    void create(Accounttype accounttype);

    void edit(Accounttype accounttype);

    void remove(Accounttype accounttype);

    Accounttype find(Object id);

    List<Accounttype> findAll();

    List<Accounttype> findRange(int[] range);

    int count();
    
}
