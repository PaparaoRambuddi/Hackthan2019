package com.dbs.hack2hire.group7.userservice.service;

import com.dbs.hack2hire.group7.userservice.controller.entity.RedemptionRule;

import java.util.List;
import java.util.Optional;

public interface RedemptionPointService {
    List<RedemptionRule> findAvailableRedemtionPointRulesForUser(Long poinLimit);
    Optional<RedemptionRule> findRedemptionRuleById(String ruleId);
}
