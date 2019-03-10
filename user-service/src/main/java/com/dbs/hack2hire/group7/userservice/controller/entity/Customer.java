package com.dbs.hack2hire.group7.userservice.controller.entity;

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

}
