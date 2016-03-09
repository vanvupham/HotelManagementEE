/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Checkin;
import entity.Customer;
import entity.Reservation;
import entity.Usedservice;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import stub.CustomerStub;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class CustomerManagedBean {
    private Customer customer;
    private String message;
    private List<Customer> listCustomer;
    /**
     * Creates a new instance of CustomerManagedBean
     */
    public CustomerManagedBean() {
        customer = new Customer();
    }

    public Integer getCustomerId() {
        return customer.getCustomerId();
    }

    public void setCustomerId(Integer customerId) {
        customer.setCustomerId(customerId);
    }

    public String getName() {
        return customer.getName();
    }

    public void setName(String name) {
        customer.setName(name);
    }

    public String getTel() {
        return customer.getTel();
    }

    public void setTel(String tel) {
        customer.setTel(tel);
    }

    public String getEmail() {
        return customer.getEmail();
    }

    public void setEmail(String email) {
        customer.setEmail(email);
    }

    public String getGender() {
        return customer.getGender();
    }

    public void setGender(String gender) {
        customer.setGender(gender);
    }

    public String getAddress() {
        return customer.getAddress();
    }

    public void setAddress(String address) {
        customer.setAddress(address);
    }

    public String getIdCard() {
        return customer.getIdCard();
    }

    public void setIdCard(String idCard) {
        customer.setIdCard(idCard);
    }

    public Date getDob() {
        return customer.getDob();
    }

    public void setDob(Date dob) {
        customer.setDob(dob);
    }

    public List<Checkin> getCheckinList() {
        return customer.getCheckinList();
    }

    public void setCheckinList(List<Checkin> checkinList) {
        customer.setCheckinList(checkinList);
    }

    public List<Usedservice> getUsedserviceList() {
        return customer.getUsedserviceList();
    }

    public void setUsedserviceList(List<Usedservice> usedserviceList) {
        customer.setUsedserviceList(usedserviceList);
    }

    public List<Reservation> getReservationList() {
        return customer.getReservationList();
    }

    public void setReservationList(List<Reservation> reservationList) {
        customer.setReservationList(reservationList);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Customer> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(List<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }
    
    public void addCustomer(){
        try{
            CustomerStub customerStub = new CustomerStub();
            customerStub.create(customer);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
