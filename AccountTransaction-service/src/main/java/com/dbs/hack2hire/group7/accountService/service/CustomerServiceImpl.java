package com.dbs.hack2hire.group7.accountService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.hack2hire.group7.accountService.controller.entity.Customer;
import com.dbs.hack2hire.group7.accountService.repository.CustomerRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	 @Autowired
	private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
   /* @Override
    public void saveOrCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> loginCustomer(Long customerId, String password) {
        return this.customerRepository.findById(customerId).filter(customer -> customer.getPassword().equals(password));
    }*/

    
   public int updateReedamPoints(long rewardsPoints, long customerId) {
    	return customerRepository.updateRewardsPoints(rewardsPoints, customerId);
    }
    
    @Override
    public Optional<Customer> findCustomerById(Long id) {
        return this.customerRepository.findById(id);
    }
}
