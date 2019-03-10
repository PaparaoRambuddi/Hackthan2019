package com.dbs.hack2hire.group7.userservice.controller.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REDEMPTION_RULE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RedemptionRule {
    @Id
    @Column(name = "RULEID", nullable = false, precision = 22, scale = 0)
    private String ruleID;

    @Column(name = "REDEMPCATEGORY", nullable = false)
    private String redemptionCategory;

    @Column(name = "MERCHANT", nullable = true)
    private String merchant;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "POINTLIMIT", nullable = false)
    private Long pointLimit;

    @Column(name = "DOLLARVALUE", nullable = false)
    private Long dollarValue;

    @Column(name = "imageURL", nullable = false)
    private String imageUrl;
}
