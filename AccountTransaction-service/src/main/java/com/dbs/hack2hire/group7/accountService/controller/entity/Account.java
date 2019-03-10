package com.dbs.hack2hire.group7.accountService.controller.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Account")
@Table(name = "ACCOUNT")
public class Account implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7427768039678380765L;

    @Id
    @Basic(optional = false)
    @Column(name = "ACCOUNTNUMBER", nullable = false)
    private String accountNumber;

    @Basic(optional = false)
    @Column(name = "CUSTOMERID", nullable = false)
    private long customerID;

    @Basic(optional = true)
    @Column(name = "ACCOUNTNAME", nullable = true)
    private String accountName;

    @Basic(optional = false)
    @Column(name = "ACCOUNTTYPE", nullable = false)
    private String accountType;

    @Basic(optional = false)
    @Column(name = "AVAILABLEBALANCE", nullable = false)
    private double availableBalance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

}
