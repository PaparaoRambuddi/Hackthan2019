package com.dbs.hack2hire.group7.userservice.repository;

import com.dbs.hack2hire.group7.userservice.controller.entity.RedemptionRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RedemptionRuleRepository extends JpaRepository<RedemptionRule,String> {
    @Query("FROM RedemptionRule r WHERE r.pointLimit<= :pointLimit")
    List<RedemptionRule> findByPointLimitLessOrEqualThan(@Param("pointLimit") Long pointLimit);

    Optional<RedemptionRule> findByRuleID(String ruleId);
}
