package com.dbs.hack2hire.group7.userservice.service;

import com.dbs.hack2hire.group7.userservice.controller.entity.RedemptionRule;
import com.dbs.hack2hire.group7.userservice.repository.RedemptionRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RedemtionPointServiceImpl implements RedemptionPointService {
    private final RedemptionRuleRepository redemptionRuleRepository;

    public RedemtionPointServiceImpl(RedemptionRuleRepository redemptionRuleRepository){
        this.redemptionRuleRepository = redemptionRuleRepository;
    }

    @Override
    public List<RedemptionRule> findAvailableRedemtionPointRulesForUser(Long poinLimit) {
        return this.redemptionRuleRepository.findByPointLimitLessOrEqualThan(poinLimit);
    }

    @Override
    public Optional<RedemptionRule> findRedemptionRuleById(String ruleId) {
        return this.redemptionRuleRepository.findByRuleID(ruleId);
    }
}
