package com.dbs.hack2hire.group7.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPointsRedemptionRequest {
    private Long customerId;
    private String ruleId;
}
