package com.dbs.hack2hire.group7.userservice.repository;

import com.dbs.hack2hire.group7.userservice.controller.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
