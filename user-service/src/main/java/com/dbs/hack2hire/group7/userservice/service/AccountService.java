package com.dbs.hack2hire.group7.userservice.service;

import com.dbs.hack2hire.group7.userservice.controller.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAccountsByCustomerId(Long customerId);
    Account updateAccount(Account account);
}
