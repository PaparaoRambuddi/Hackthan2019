package com.dbs.hack2hire.group7.userservice.service;

import com.dbs.hack2hire.group7.userservice.controller.entity.Customer;
import com.dbs.hack2hire.group7.userservice.dto.CustomerPoint;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CustomerService {
    Customer saveOrUpdateCustomer(Customer customer);
    Optional<Customer> loginCustomer(String email, String password);
    Optional<Customer> findCustomerById(Long customerId);
    @Transactional
    Customer updateCustomerPoints(CustomerPoint customerPoint);
}
