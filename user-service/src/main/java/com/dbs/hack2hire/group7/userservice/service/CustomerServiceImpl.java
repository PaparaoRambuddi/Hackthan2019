package com.dbs.hack2hire.group7.userservice.service;

import com.dbs.hack2hire.group7.userservice.controller.entity.Customer;
import com.dbs.hack2hire.group7.userservice.dto.CustomerPoint;
import com.dbs.hack2hire.group7.userservice.exception.CustomerNotFoundException;
import com.dbs.hack2hire.group7.userservice.repository.CustomerRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@NoArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
//        if(customer.getPassword()!=null){
//            customer.setPassword(this.passwordEncoder.encode(customer.getPassword()));
//        }
        return this.customerRepository.saveAndFlush(customer);
    }

    @Override
    public Optional<Customer> loginCustomer(String email, String password) {
        return this.customerRepository.findByEmail(email).filter(customer -> password.equals(customer.getPassword()));
    }

    @Override
    public Optional<Customer> findCustomerById(Long customerId) {
        return this.customerRepository.findById(customerId);
    }

    @Override
    public Customer updateCustomerPoints(CustomerPoint customerPoint) {
        Customer customer = this.customerRepository.findById(customerPoint.getCustomerId()).orElseThrow(()->{
                    CustomerNotFoundException e = new CustomerNotFoundException();
                    e.setErrorCode(404);
                    e.setErrorMessages(Stream.of("Customer not found").collect(Collectors.toList()));
                    return e;
                }
        );
        customer.setRewardsPoints(customer.getRewardsPoints()+customerPoint.getPoints());
        return this.customerRepository.saveAndFlush(customer);
    }
}
