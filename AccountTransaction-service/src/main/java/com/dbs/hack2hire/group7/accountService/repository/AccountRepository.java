package com.dbs.hack2hire.group7.accountService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.dbs.hack2hire.group7.accountService.controller.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "Select * from ACCOUNT where CUSTOMERID =?1", nativeQuery = true)
    Account fineAccountByCustomerID(Long customerID);

    @Query(value = "Select * from ACCOUNT where ACCOUNTNUMBER =?1", nativeQuery = true)
    Account findByAccountNumber(String accountNumber);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update ACCOUNT set AVAILABLEBALANCE=?1 where ACCOUNTNUMBER =?2",nativeQuery = true)
    int updateAccount(double currentBalance, String accountNumber);

}
