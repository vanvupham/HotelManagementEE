/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Checkout;
import entity.Customer;
import entity.Service;
import entity.Usedservice;
import java.math.BigDecimal;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class UsedServiceManagedBean {
    private Usedservice usedService;
    private String message;
    /**
     * Creates a new instance of UsedServiceManagedBean
     */
    public UsedServiceManagedBean() {
    }

    public Integer getUsedServiceId() {
        return usedService.getUsedServiceId();
    }

    public void setUsedServiceId(Integer usedServiceId) {
        usedService.setUsedServiceId(usedServiceId);
    }

    public int getAmount() {
        return usedService.getAmount();
    }

    public void setAmount(int amount) {
        usedService.setAmount(amount);
    }

    public BigDecimal getTotalPrice() {
        return usedService.getTotalPrice();
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        usedService.setTotalPrice(totalPrice);
    }

    public Customer getCustomerId() {
        return usedService.getCustomerId();
    }

    public void setCustomerId(Customer customerId) {
        usedService.setCustomerId(customerId);
    }

    public Service getServiceId() {
        return usedService.getServiceId();
    }

    public void setServiceId(Service serviceId) {
        usedService.setServiceId(serviceId);
    }

    public List<Checkout> getCheckoutList() {
        return usedService.getCheckoutList();
    }

    public void setCheckoutList(List<Checkout> checkoutList) {
        usedService.setCheckoutList(checkoutList);
    }

    public Usedservice getUsedService() {
        return usedService;
    }

    public void setUsedService(Usedservice usedService) {
        this.usedService = usedService;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
}
