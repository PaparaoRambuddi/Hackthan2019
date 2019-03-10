package com.dbs.hack2hire.group7.accountService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.hack2hire.group7.accountService.controller.entity.Account;
import com.dbs.hack2hire.group7.accountService.controller.entity.Transaction;
import com.dbs.hack2hire.group7.accountService.repository.AccountRepository;
import com.dbs.hack2hire.group7.accountService.repository.TransactionRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
    private AccountRepository accountRepository;

    
    

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    
    @Override
    public boolean creditAccount(String accountNumber, double amount){

        Account account = findByAccountNumber(accountNumber);
        int updateCount=0;
        if(account!=null && account.getAccountName()!= null){
	
             double balance = account.getAvailableBalance() + amount;
             account.setAvailableBalance(balance);
             updateCount = updateNewBalance(account.getAvailableBalance(), account.getAccountNumber());

             if(updateCount>0)
                 return true;
             else
                 return false;
        }
        else
            return false;
    }


    private Account findByAccountNumber(String accountNumber) {
        return this.accountRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public boolean debitAccount(String accountNumber, double amount){

        Account account = findByAccountNumber(accountNumber);
        int updateCount=0;
        if(account.getAccountName()!= null){

            if(account.getAvailableBalance()> amount){
                double balance = account.getAvailableBalance() - amount;

                account.setAvailableBalance(balance);
                updateCount = updateNewBalance(account.getAvailableBalance(), account.getAccountNumber());

                if(updateCount>0)
                    return true;
                else
                    return false;
            }
            else
                return false;

        }
        else
            return false;

    }

    @Override
    public int updateNewBalance(double currentBalance, String accountNumber) {
        return this.accountRepository.updateAccount(currentBalance,accountNumber);
    }

    @Override
    public Optional<Account> findAccount(long customerID){
        return this.accountRepository.findById(customerID);
    }

    @Override
    public boolean initateTransaction(String bankAccount_from, String bankAccount_to, double transaction_amount) {
    	/*System.out.println("initateTransaction || "+bankAccount_to + bankAccount_from );
        if(debitAccount(bankAccount_from,transaction_amount) && creditAccount(bankAccount_to,transaction_amount))
            return true;
        else
            return false;*/
    	
    	 if(debitAccount(bankAccount_from,transaction_amount)){
             if(creditAccount(bankAccount_to,transaction_amount))
                 return true;
             else{
                 if(creditAccount(bankAccount_from,transaction_amount))
                     return false;
             }
         }
         return false;
    }
}