package com.dbs.hack2hire.group7.accountService.service;

import java.util.Optional;

import com.dbs.hack2hire.group7.accountService.controller.entity.Account;

public interface AccountService {

	public boolean creditAccount(String accountNumber, double amount);

    boolean debitAccount(String accountNumber, double amount);

    Optional<Account> findAccount(long customerID);

    boolean initateTransaction(String bankAccount_from, String bankAccount_to, double transaction_amount);

    int updateNewBalance(double currentBalance, String accountNumber);
    
}
