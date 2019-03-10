package com.dbs.hack2hire.group7.accountService.controller.entity;

	
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String documentId;
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    private String incomeRange;
    private String occupation;
    private String residentialAddress;
    private String communicationAddress;
    private Integer age;
    private Boolean isMale;
    private Boolean isSingle;
    @JsonIgnore
    private String password;
    private Long rewardsPoints;
    @Transient
    private Double availableBalance;
    @Transient
    private String accountNumber;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIncomeRange() {
		return incomeRange;
	}
	public void setIncomeRange(String incomeRange) {
		this.incomeRange = incomeRange;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getResidentialAddress() {
		return residentialAddress;
	}
	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}
	public String getCommunicationAddress() {
		return communicationAddress;
	}
	public void setCommunicationAddress(String communicationAddress) {
		this.communicationAddress = communicationAddress;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boolean getIsMale() {
		return isMale;
	}
	public void setIsMale(Boolean isMale) {
		this.isMale = isMale;
	}
	public Boolean getIsSingle() {
		return isSingle;
	}
	public void setIsSingle(Boolean isSingle) {
		this.isSingle = isSingle;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getRewardsPoints() {
		return rewardsPoints;
	}
	public void setRewardsPoints(Long rewardsPoints) {
		this.rewardsPoints = rewardsPoints;
	}
	public Double getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}

