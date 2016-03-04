/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Account;
import entity.Accounttype;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class AccountTypeManagedBean {
    private Accounttype accounttype;
    private String message;
    private List<Accounttype> listAccounttype;
    /**
     * Creates a new instance of AccountTypeManagedBean
     */
    public AccountTypeManagedBean() {
    }

    public Integer getAccountTypeId() {
        return accounttype.getAccountTypeId();
    }

    public void setAccountTypeId(Integer accountTypeId) {
        accounttype.setAccountTypeId(accountTypeId);
    }

    public String getAccountTypeName() {
        return accounttype.getAccountTypeName();
    }

    public void setAccountTypeName(String accountTypeName) {
        accounttype.setAccountTypeName(accountTypeName);
    }

    public List<Account> getAccountList() {
        return accounttype.getAccountList();
    }

    public void setAccountList(List<Account> accountList) {
        accounttype.setAccountList(accountList);
    }

    public Accounttype getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(Accounttype accounttype) {
        this.accounttype = accounttype;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Accounttype> getListAccounttype() {
        return listAccounttype;
    }

    public void setListAccounttype(List<Accounttype> listAccounttype) {
        this.listAccounttype = listAccounttype;
    }
    
}
