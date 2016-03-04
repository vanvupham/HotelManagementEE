/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.Account;
import entity.Accounttype;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import stub.AccountStub;
import security.MD5;
import sessionbean.SessionBean;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class AccountManagedBean {

    private Account account;
    private String message;
    private String user;
    private String pass;
    private String position;
    private List<Account> listAccount;
    private boolean loggedIn;

    /**
     * Creates a new instance of AccountManagedBean
     */
    public AccountManagedBean() {
        account = new Account();
        listAccount = new ArrayList<Account>();
    }

    public Integer getAccountID() {
        return account.getAccountID();
    }

    public void setAccountID(Integer accountID) {
        account.setAccountID(accountID);
    }

    public String getUsername() {
        return account.getUsername();
    }

    public void setUsername(String username) {
        account.setUsername(username);
    }

    public String getPassword() {
        return account.getPassword();
    }

    public void setPassword(String password) {
        account.setPassword(password);
    }

    public String getFirstName() {
        return account.getFirstName();
    }

    public void setFirstName(String firstName) {
        account.setFirstName(firstName);
    }

    public String getLastName() {
        return account.getLastName();
    }

    public void setLastName(String lastName) {
        account.setLastName(lastName);
    }

    public int getIdCard() {
        return account.getIdCard();
    }

    public void setIdCard(int idCard) {
        account.setIdCard(idCard);
    }

    public Date getDob() {
        return account.getDob();
    }

    public void setDob(Date dob) {
        account.setDob(dob);
    }

    public String getTel() {
        return account.getTel();
    }

    public void setTel(String tel) {
        account.setTel(tel);
    }

    public String getGender() {
        return account.getGender();
    }

    public void setGender(String gender) {
        account.setGender(gender);
    }

    public String getAddress() {
        return account.getAddress();
    }

    public void setAddress(String address) {
        account.setAddress(address);
    }

    public String getEmail() {
        return account.getEmail();
    }

    public void setEmail(String email) {
        account.setEmail(email);
    }

    public Accounttype getAccountTypeId() {
        return account.getAccountTypeId();
    }

    public void setAccountTypeId(Accounttype accountTypeId) {
        account.setAccountTypeId(accountTypeId);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Account> getListAccount() {
        return listAccount;
    }

    public void setListAccount(List<Account> listAccount) {
        this.listAccount = listAccount;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String login() {
        String url = "";
        try {
            AccountStub accountStub = new AccountStub();
            MD5 md5 = new MD5();
            String passMD5 = md5.MD5(pass);
            account = accountStub.findUserAndPass(user, passMD5);

            if (account.getAccountTypeId().getAccountTypeId() == 1) {
                url = "manager";
                HttpSession session = SessionBean.getSession();
                session.setAttribute("username", user);
                loggedIn = true;
            }
            if (account.getAccountTypeId().getAccountTypeId() == 2) {
                url = "staff";
                HttpSession session = SessionBean.getSession();
                session.setAttribute("username", user);
                loggedIn = true;
            }
            if (account.getAccountTypeId().getAccountTypeId() == 3) {
                url = "receptionist";
                HttpSession session = SessionBean.getSession();
                session.setAttribute("username", user);
                loggedIn = true;
            }
            return url;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public String logout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
        httpSession.invalidate();
        return "/login.xhtml?faces-redirect=true";
    }

    public String createAccount() {
        message = "";
        try {
            AccountStub accountStub = new AccountStub();
            Account newAccount = new Account();
            newAccount.setUsername(account.getUsername());
            MD5 md5 = new MD5();
            String passMD5 = md5.MD5(account.getPassword());
            newAccount.setPassword(passMD5);
            newAccount.setFirstName(account.getFirstName());
            newAccount.setLastName(account.getLastName());
            newAccount.setIdCard(account.getIdCard());
            newAccount.setDob(account.getDob());
            newAccount.setTel(account.getTel());
            newAccount.setGender(account.getGender());
            newAccount.setAddress(account.getAddress());
            newAccount.setEmail(account.getEmail());
            if (position.equalsIgnoreCase("M")) {
                newAccount.setAccountTypeId(new Accounttype(1));
            }
            if (position.equalsIgnoreCase("S")) {
                newAccount.setAccountTypeId(new Accounttype(2));
            }
            if (position.equalsIgnoreCase("R")) {
                newAccount.setAccountTypeId(new Accounttype(3));
            }
            accountStub.create(newAccount);
            return message = "Create Successfull";
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Account> findAll() {
        try {
            AccountStub accountStub = new AccountStub();
            listAccount = accountStub.findAll();
            return listAccount;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
