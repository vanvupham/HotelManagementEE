/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

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
public class ServiceManagedBean {
    private Service service;
    private String message;
    /**
     * Creates a new instance of ServiceManagedBean
     */
    public ServiceManagedBean() {
    }

    public Integer getServiceId() {
        return service.getServiceId();
    }

    public void setServiceId(Integer serviceId) {
        service.setServiceId(serviceId);
    }

    public String getServiceName() {
        return service.getServiceName();
    }

    public void setServiceName(String serviceName) {
        service.setServiceName(serviceName);
    }

    public String getDescription() {
        return service.getDescription();
    }

    public void setDescription(String description) {
        service.setDescription(description);
    }

    public BigDecimal getPrice() {
        return service.getPrice();
    }

    public void setPrice(BigDecimal price) {
        service.setPrice(price);
    }

    public List<Usedservice> getUsedserviceList() {
        return service.getUsedserviceList();
    }

    public void setUsedserviceList(List<Usedservice> usedserviceList) {
        service.setUsedserviceList(usedserviceList);
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
