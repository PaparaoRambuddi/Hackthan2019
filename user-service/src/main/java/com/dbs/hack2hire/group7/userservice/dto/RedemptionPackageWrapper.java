package com.dbs.hack2hire.group7.userservice.dto;

import com.dbs.hack2hire.group7.userservice.controller.entity.RedemptionRule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedemptionPackageWrapper {
    private Long redemptionPoints;
    private List<RedemptionRule> redemptionPackages;
}
