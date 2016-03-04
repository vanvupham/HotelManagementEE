/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Willi
 */
@Entity
@Table(name = "usedservice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usedservice.findAll", query = "SELECT u FROM Usedservice u"),
    @NamedQuery(name = "Usedservice.findByUsedServiceId", query = "SELECT u FROM Usedservice u WHERE u.usedServiceId = :usedServiceId"),
    @NamedQuery(name = "Usedservice.findByAmount", query = "SELECT u FROM Usedservice u WHERE u.amount = :amount"),
    @NamedQuery(name = "Usedservice.findByTotalPrice", query = "SELECT u FROM Usedservice u WHERE u.totalPrice = :totalPrice")})
public class Usedservice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usedServiceId")
    private Integer usedServiceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalPrice")
    private BigDecimal totalPrice;
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    @ManyToOne(optional = false)
    private Customer customerId;
    @JoinColumn(name = "serviceId", referencedColumnName = "serviceId")
    @ManyToOne(optional = false)
    private Service serviceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userServiceId")
    private List<Checkout> checkoutList;

    public Usedservice() {
    }

    public Usedservice(Integer usedServiceId) {
        this.usedServiceId = usedServiceId;
    }

    public Usedservice(Integer usedServiceId, int amount, BigDecimal totalPrice) {
        this.usedServiceId = usedServiceId;
        this.amount = amount;
        this.totalPrice = totalPrice;
    }

    public Integer getUsedServiceId() {
        return usedServiceId;
    }

    public void setUsedServiceId(Integer usedServiceId) {
        this.usedServiceId = usedServiceId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Service getServiceId() {
        return serviceId;
    }

    public void setServiceId(Service serviceId) {
        this.serviceId = serviceId;
    }

    @XmlTransient
    public List<Checkout> getCheckoutList() {
        return checkoutList;
    }

    public void setCheckoutList(List<Checkout> checkoutList) {
        this.checkoutList = checkoutList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usedServiceId != null ? usedServiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usedservice)) {
            return false;
        }
        Usedservice other = (Usedservice) object;
        if ((this.usedServiceId == null && other.usedServiceId != null) || (this.usedServiceId != null && !this.usedServiceId.equals(other.usedServiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usedservice[ usedServiceId=" + usedServiceId + " ]";
    }
    
}
