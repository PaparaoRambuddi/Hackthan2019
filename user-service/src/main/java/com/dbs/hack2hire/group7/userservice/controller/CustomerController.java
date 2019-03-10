package com.dbs.hack2hire.group7.userservice.controller;

import com.dbs.hack2hire.group7.userservice.controller.entity.Account;
import com.dbs.hack2hire.group7.userservice.controller.entity.Customer;
import com.dbs.hack2hire.group7.userservice.dto.CustomerLoginDto;
import com.dbs.hack2hire.group7.userservice.dto.CustomerPoint;
import com.dbs.hack2hire.group7.userservice.exception.CustomerNotFoundException;
import com.dbs.hack2hire.group7.userservice.service.AccountService;
import com.dbs.hack2hire.group7.userservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    private CustomerService customerService;
    private AccountService accountService;
    CustomerController(CustomerService customerService,AccountService accountService){
        this.customerService = customerService;
        this.accountService = accountService;
    }
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable("id") Long customerId){
        Customer customer = this.customerService.findCustomerById(customerId).orElseThrow(()->{
                    CustomerNotFoundException e = new CustomerNotFoundException();
                    e.setErrorCode(404);
                    e.setErrorMessages(Stream.of("Customer not found").collect(Collectors.toList()));
                    return e;
        }
        );
        setCustomerAccountBalance(customer);
        return customer;
    }

    @PostMapping(value="/customers/login",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public Customer loginCustomer(@RequestBody CustomerLoginDto loggedInCustomer){
        Customer customer = this.customerService.loginCustomer(loggedInCustomer.getEmail(),loggedInCustomer.getPassword()).orElseThrow(()->{
                    CustomerNotFoundException e = new CustomerNotFoundException();
                    e.setErrorCode(404);
                    e.setErrorMessages(Stream.of("Either email or password is incorrect").collect(Collectors.toList()));
                    return e;
                }
        );
        setCustomerAccountBalance(customer);
        return customer;
    }

    @PostMapping(value = "/customers/points",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> updateCustomerRewardPoints(@RequestBody CustomerPoint customerPoint){
        this.customerService.updateCustomerPoints(customerPoint);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    private void setCustomerAccountBalance(Customer customer){
        Supplier<Stream<Account>> accountStreamSupplier = ()->accountService.findAccountsByCustomerId(customer.getId()).stream();
        Double avilableBalance = accountStreamSupplier.get().mapToDouble(e->e.getAvailableBalance()).sum();
        customer.setAvailableBalance(avilableBalance);
        customer.setAccountNumber(accountStreamSupplier.get().findFirst().map(a->a.getAccountNumber()).orElse(null));
    }
}
