package com.dbs.hack2hire.group7.userservice;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dbs.hack2hire.group7.accountService.controller.entity.Customer;
import com.dbs.hack2hire.group7.accountService.repository.CustomerRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class CustomerServiceImpl implements CustomerService {
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

    @Override
    public Optional<Customer> findCustomerById(Long customerId) {
        return this.customerRepository.findById(customerId);
    }
}
