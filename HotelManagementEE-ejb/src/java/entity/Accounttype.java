/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Willi
 */
@Entity
@Table(name = "accounttype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounttype.findAll", query = "SELECT a FROM Accounttype a"),
    @NamedQuery(name = "Accounttype.findByAccountTypeId", query = "SELECT a FROM Accounttype a WHERE a.accountTypeId = :accountTypeId"),
    @NamedQuery(name = "Accounttype.findByAccountTypeName", query = "SELECT a FROM Accounttype a WHERE a.accountTypeName = :accountTypeName")})
public class Accounttype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "accountTypeId")
    private Integer accountTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "accountTypeName")
    private String accountTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountTypeId")
    private List<Account> accountList;

    public Accounttype() {
    }

    public Accounttype(Integer accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public Accounttype(Integer accountTypeId, String accountTypeName) {
        this.accountTypeId = accountTypeId;
        this.accountTypeName = accountTypeName;
    }

    public Integer getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Integer accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @XmlTransient
    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountTypeId != null ? accountTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounttype)) {
            return false;
        }
        Accounttype other = (Accounttype) object;
        if ((this.accountTypeId == null && other.accountTypeId != null) || (this.accountTypeId != null && !this.accountTypeId.equals(other.accountTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Accounttype[ accountTypeId=" + accountTypeId + " ]";
    }
    
}
