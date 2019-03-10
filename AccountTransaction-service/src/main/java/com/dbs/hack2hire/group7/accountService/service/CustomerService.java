package com.dbs.hack2hire.group7.accountService.service;

import java.util.Optional;

import com.dbs.hack2hire.group7.accountService.controller.entity.Customer;

public interface CustomerService {
	// void saveOrCustomer(Customer customer);
	    //Optional<Customer> loginCustomer(Long customerId, String password);
	    Optional<Customer> findCustomerById(Long customerId);
	    int updateReedamPoints(long rewardsPoints, long customerId);
}
