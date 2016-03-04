/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Checkin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Willi
 */
@Local
public interface CheckinFacadeLocal {

    void create(Checkin checkin);

    void edit(Checkin checkin);

    void remove(Checkin checkin);

    Checkin find(Object id);

    List<Checkin> findAll();

    List<Checkin> findRange(int[] range);

    int count();
    
}
