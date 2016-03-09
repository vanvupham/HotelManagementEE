/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Checkin;
import entity.Checkout;
import entity.Customer;
import entity.Room;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import stub.CheckinStub;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class CheckinManagedBean {
    private Checkin checkin;
    private String message;
    private List<Checkin> listCheckin;
    /**
     * Creates a new instance of CheckinManagedBean
     */
    public CheckinManagedBean() {
        checkin = new Checkin();
    }

    public Integer getCheckinId() {
        return checkin.getCheckinId();
    }

    public void setCheckinId(Integer checkinId) {
        checkin.setCheckinId(checkinId);
    }

    public Date getDateIn() {
        return checkin.getDateIn();
    }

    public void setDateIn(Date dateIn) {
        checkin.setDateIn(dateIn);
    }

    public Date getDateOut() {
        return checkin.getDateOut();
    }

    public void setDateOut(Date dateOut) {
        checkin.setDateOut(dateOut);
    }

    public BigDecimal getDiscount() {
        return checkin.getDiscount();
    }

    public void setDiscount(BigDecimal discount) {
        checkin.setDiscount(discount);
    }

    public int getTax() {
        return checkin.getTax();
    }

    public void setTax(int tax) {
        checkin.setTax(tax);
    }

    public int getOutOfTime() {
        return checkin.getOutOfTime();
    }

    public void setOutOfTime(int outOfTime) {
        checkin.setOutOfTime(outOfTime);
    }

    public BigDecimal getRoomCharge() {
        return checkin.getRoomCharge();
    }

    public void setRoomCharge(BigDecimal roomCharge) {
        checkin.setRoomCharge(roomCharge);
    }

    public String getRoomStatus() {
        return checkin.getRoomStatus();
    }

    public void setRoomStatus(String roomStatus) {
        checkin.setRoomStatus(roomStatus);
    }

    public String getComment() {
        return checkin.getComment();
    }

    public void setComment(String comment) {
        checkin.setComment(comment);
    }

    public Customer getCustomerId() {
        return checkin.getCustomerId();
    }

    public void setCustomerId(Customer customerId) {
        checkin.setCustomerId(customerId);
    }

    public Room getRoomId() {
        return checkin.getRoomId();
    }

    public void setRoomId(Room roomId) {
        checkin.setRoomId(roomId);
    }

    public List<Checkout> getCheckoutList() {
        return checkin.getCheckoutList();
    }

    public void setCheckoutList(List<Checkout> checkoutList) {
        checkin.setCheckoutList(checkoutList);
    }

    public Checkin getCheckin() {
        return checkin;
    }

    public void setCheckin(Checkin checkin) {
        this.checkin = checkin;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Checkin> getListCheckin() {
        return listCheckin;
    }

    public void setListCheckin(List<Checkin> listCheckin) {
        this.listCheckin = listCheckin;
    }
    
//    public String addCheckin(){
//        message="";
//        try{
//            CheckinStub checkinStub = new CheckinStub();
//            Checkin newCheckin = new Checkin();
//            newCheckin.setDateIn(checkin.getDateIn());
//            newCheckin.setDateOut(checkin.getDateOut());
//            newCheckin.setDiscount(checkin.getDiscount());
//            newCheckin.setTax(checkin.getTax());
//            
//        }catch(Exception ex){
//            message=getMessage();
//        }
//    }
}
