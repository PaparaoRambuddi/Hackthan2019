package com.dbs.hack2hire.group7.userservice.repository;

import com.dbs.hack2hire.group7.userservice.controller.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,String> {
    List<Account> findBycustomerId(Long customerId);
}
