package com.dbs.hack2hire.group7.accountService.service;

import java.util.List;

import com.dbs.hack2hire.group7.accountService.controller.entity.Transaction;


public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);
     List<Transaction> getTransactionHistory(String account_id);
    //Optional<Transaction> loginCustomer(Long customerId, String password);
    //Optional<Transaction> findCustomerById(Long customerId);
}