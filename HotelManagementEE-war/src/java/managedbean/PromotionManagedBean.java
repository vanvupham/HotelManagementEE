/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Promotion;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class PromotionManagedBean {
    private Promotion promotion;
    private String message;
    /**
     * Creates a new instance of PromotionManagedBean
     */
    public PromotionManagedBean() {
    }

    public Integer getPromotionId() {
        return promotion.getPromotionId();
    }

    public void setPromotionId(Integer promotionId) {
        promotion.setPromotionId(promotionId);
    }

    public String getPromotionName() {
        return promotion.getPromotionName();
    }

    public void setPromotionName(String promotionName) {
        promotion.setPromotionName(promotionName);
    }

    public Date getStarDate() {
        return promotion.getStarDate();
    }

    public void setStarDate(Date starDate) {
        promotion.setStarDate(starDate);
    }

    public Date getEndDate() {
        return promotion.getEndDate();
    }

    public void setEndDate(Date endDate) {
        promotion.setEndDate(endDate);
    }

    public String getDescription() {
        return promotion.getDescription();
    }

    public void setDescription(String description) {
        promotion.setDescription(description);
    }

    public int hashCode() {
        return promotion.hashCode();
    }

    public boolean equals(Object object) {
        return promotion.equals(object);
    }

    public String toString() {
        return promotion.toString();
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
