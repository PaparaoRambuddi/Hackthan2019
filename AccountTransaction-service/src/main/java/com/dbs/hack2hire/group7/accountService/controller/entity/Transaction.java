package com.dbs.hack2hire.group7.accountService.controller.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	
    
    @Column(name = "transaction_id")
	//@GeneratedValue(strategy=GenerationType.AUTO)
    private String transaction_id;
    
	
    @Column(name = "account_id")	
	private String account_id;	
    @Column(name = "customer_id")	
    private Long customer_id;
	
    @Column(name = "transaction_type")	
    private String transaction_type;
	
    @Column(name = "transaction_code")
	
    private String transaction_code;
	
    @Column(name = "transaction_amount")
	
    private double transaction_amount;
	
    @Column(name = "transaction_category")
	
    private String transaction_category;
	
    @Column(name = "creation_date")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date creation_date;
    @Column(name = "reward_jack_point")
    private long reward_jack_point;
    
    public long getReward_jack_point() {
		return reward_jack_point;
	}
	public void setReward_jack_point(long reward_jack_point) {
		this.reward_jack_point = reward_jack_point;
	}
	@Column(name = "bank_account_from")
    private String bank_account_from;
    @Column(name = "bank_account_to")
    private String bank_account_to;
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "status")
    private String status;
    
    @Transient
    private String device_key;
	
    
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public String getTransaction_code() {
		return transaction_code;
	}
	public void setTransaction_code(String transaction_code) {
		this.transaction_code = transaction_code;
	}
	public double getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public String getTransaction_category() {
		return transaction_category;
	}
	public void setTransaction_category(String transaction_category) {
		this.transaction_category = transaction_category;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	
	public String getBank_account_from() {
		return bank_account_from;
	}
	public void setBank_account_from(String bank_account_from) {
		this.bank_account_from = bank_account_from;
	}
	public String getBank_account_to() {
		return bank_account_to;
	}
	public void setBank_account_to(String bank_account_to) {
		this.bank_account_to = bank_account_to;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDevice_key() {
		return device_key;
	}
	public void setDevice_key(String device_key) {
		this.device_key = device_key;
	}
	  
	
}
