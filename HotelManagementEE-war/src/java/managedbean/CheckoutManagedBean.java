/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Checkin;
import entity.Checkout;
import entity.Usedservice;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class CheckoutManagedBean {
    private Checkout checkout;
    private String message;
    private List<Checkout> listCheckout;
    /**
     * Creates a new instance of CheckoutManagedBean
     */
    public CheckoutManagedBean() {
    }

    public Integer getCheckOutId() {
        return checkout.getCheckOutId();
    }

    public void setCheckOutId(Integer checkOutId) {
        checkout.setCheckOutId(checkOutId);
    }

    public Checkin getCheckInId() {
        return checkout.getCheckInId();
    }

    public void setCheckInId(Checkin checkInId) {
        checkout.setCheckInId(checkInId);
    }

    public Usedservice getUserServiceId() {
        return checkout.getUserServiceId();
    }

    public void setUserServiceId(Usedservice userServiceId) {
        checkout.setUserServiceId(userServiceId);
    }

    public Checkout getCheckout() {
        return checkout;
    }

    public void setCheckout(Checkout checkout) {
        this.checkout = checkout;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Checkout> getListCheckout() {
        return listCheckout;
    }

    public void setListCheckout(List<Checkout> listCheckout) {
        this.listCheckout = listCheckout;
    }
    
}
