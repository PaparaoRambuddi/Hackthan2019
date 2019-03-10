package com.dbs.hack2hire.group7.userservice.controller.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    @Id
    @Column(name = "ACCOUNTNUMBER", nullable = false)
    private String accountNumber;
    @Column(name = "ACCOUNTNAME", nullable = true)
    private String accountName;
    @Column(name = "ACCOUNTTYPE", nullable = false)
    private String accountType;
    @Column(name = "AVAILABLEBALANCE", nullable = false)
    private Double availableBalance;
    @Column(name = "CUSTOMERID", nullable = false)
    private Long customerId;
}
