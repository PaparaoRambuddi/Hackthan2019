package com.dbs.hack2hire.group7.accountService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.hack2hire.group7.accountService.controller.entity.Transaction;
import com.dbs.hack2hire.group7.accountService.repository.TransactionRepository;


import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }
    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return this.transactionRepository.save(transaction);
    }
    
    
    public List<Transaction> getTransactionHistory(String account_id){
    	return this.transactionRepository.getTransactionHistory(account_id,"SUCCESS");
    }
    
   /* @Override
    public Optional<TransactionRepository> loginCustomer(Long customerId, String password) {
        return this.customerRepository.findById(customerId).filter(customer -> customer.getPassword().equals(password));
    }

    @Override
    public Optional<TransactionRepository> findCustomerById(Long customerId) {
        return this.customerRepository.findById(customerId);
    }*/
}
