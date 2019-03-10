package com.dbs.hack2hire.group7.userservice.service;

import com.dbs.hack2hire.group7.userservice.controller.entity.Account;
import com.dbs.hack2hire.group7.userservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    @Override
    public List<Account> findAccountsByCustomerId(Long customerId) {
        return this.accountRepository.findBycustomerId(customerId);
    }

    @Override
    public Account updateAccount(Account account) {
        return this.accountRepository.saveAndFlush(account);
    }
}
