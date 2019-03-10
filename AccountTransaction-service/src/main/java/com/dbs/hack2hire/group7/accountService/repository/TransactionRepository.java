package com.dbs.hack2hire.group7.accountService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dbs.hack2hire.group7.accountService.controller.entity.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query(value = "Select * from TRANSACTION where  ACCOUNT_ID =?1  and STATUS=?2 ORDER BY CREATION_DATE DESC",nativeQuery = true)
    List<Transaction> getTransactionHistory(String account_id, String status);

}