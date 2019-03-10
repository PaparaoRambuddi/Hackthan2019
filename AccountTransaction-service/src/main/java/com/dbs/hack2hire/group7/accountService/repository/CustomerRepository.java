package com.dbs.hack2hire.group7.accountService.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.dbs.hack2hire.group7.accountService.controller.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	 @Modifying(clearAutomatically = true)
	    @Transactional
	    @Query(value = "update Customer set REWARDS_POINTS=?1 where ID =?2",nativeQuery = true)
	    int updateRewardsPoints(long rewardsPoints, long customerId);


}
