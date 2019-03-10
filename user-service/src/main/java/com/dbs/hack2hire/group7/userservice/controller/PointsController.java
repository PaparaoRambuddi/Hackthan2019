package com.dbs.hack2hire.group7.userservice.controller;

import com.dbs.hack2hire.group7.userservice.controller.entity.Account;
import com.dbs.hack2hire.group7.userservice.controller.entity.Customer;
import com.dbs.hack2hire.group7.userservice.controller.entity.RedemptionRule;
import com.dbs.hack2hire.group7.userservice.dto.CustomerPointsRedemptionRequest;
import com.dbs.hack2hire.group7.userservice.dto.RedemptionPackageWrapper;
import com.dbs.hack2hire.group7.userservice.exception.CustomerNotFoundException;
import com.dbs.hack2hire.group7.userservice.exception.NotEnoughRedemptionPointsException;
import com.dbs.hack2hire.group7.userservice.service.AccountService;
import com.dbs.hack2hire.group7.userservice.service.CustomerService;
import com.dbs.hack2hire.group7.userservice.service.RedemptionPointService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/customers")
public class PointsController {
    private final CustomerService customerService;
    private final RedemptionPointService redemptionPointService;
    private final AccountService accountService;
    public PointsController(CustomerService customerService,RedemptionPointService redemptionPointService,AccountService accountService){
        this.customerService = customerService;
        this.redemptionPointService = redemptionPointService;
        this.accountService = accountService;
    }
    @GetMapping("/{customerId}/point-rules")
    public RedemptionPackageWrapper getRedemptionPointRulesForCustomer(@PathVariable("customerId") Long customerId){
        Customer customer = this.customerService.findCustomerById(customerId).orElseThrow(()->{
                    CustomerNotFoundException e = new CustomerNotFoundException();
                    e.setErrorCode(404);
                    e.setErrorMessages(Stream.of("Customer not found").collect(Collectors.toList()));
                    return e;
                }
        );
        if(customer.getRewardsPoints()>0){
            return new RedemptionPackageWrapper(customer.getRewardsPoints(),this.redemptionPointService.findAvailableRedemtionPointRulesForUser(customer.getRewardsPoints()));
        }
        else
            return new RedemptionPackageWrapper(customer.getRewardsPoints(),new ArrayList<>());
    }

    @PutMapping("/redemption-points")
    public RedemptionPackageWrapper consumeCustomerRedemptionPoints(@RequestBody CustomerPointsRedemptionRequest reedemPoints){
        Customer customer = this.customerService.findCustomerById(reedemPoints.getCustomerId()).orElseThrow(()->{
                    CustomerNotFoundException e = new CustomerNotFoundException();
                    e.setErrorCode(404);
                    e.setErrorMessages(Stream.of("Customer not found").collect(Collectors.toList()));
                    return e;
                }
        );
        if(customer.getRewardsPoints()>0){
            Optional<RedemptionRule> rule = this.redemptionPointService.findRedemptionRuleById(reedemPoints.getRuleId());
            if(rule.orElse(null)!=null){
                Long remaining = customer.getRewardsPoints() - rule.get().getPointLimit();
                if(remaining>=0){
                    customer.setRewardsPoints(remaining);
                    customerService.saveOrUpdateCustomer(customer);
                    if("TRANSFER".equals(rule.get().getRedemptionCategory()))
                        setCustomerAccountWhenRedemptionIsCash(customer,rule.get().getDollarValue().doubleValue());
                }
                else{
                    NotEnoughRedemptionPointsException p = new NotEnoughRedemptionPointsException();
                    p.setErrorCode(417);
                    p.setErrorMessages(Stream.of("Not enough redemption points available").collect(Collectors.toList()));
                }
            }
        }
        else{
            NotEnoughRedemptionPointsException p = new NotEnoughRedemptionPointsException();
            p.setErrorCode(417);
            p.setErrorMessages(Stream.of("Not enough redemption points available").collect(Collectors.toList()));
        }
        if(customer.getRewardsPoints()>0){
            return new RedemptionPackageWrapper(customer.getRewardsPoints(),this.redemptionPointService.findAvailableRedemtionPointRulesForUser(customer.getRewardsPoints()));
        }
        else
            return new RedemptionPackageWrapper(customer.getRewardsPoints(),new ArrayList<>());
    }

    private void setCustomerAccountWhenRedemptionIsCash(Customer customer,Double cash){
        Supplier<Stream<Account>> accountStreamSupplier = ()->accountService.findAccountsByCustomerId(customer.getId()).stream();
        Double availableBalance = accountStreamSupplier.get().mapToDouble(e->e.getAvailableBalance()).sum();
        accountStreamSupplier.get().findFirst().ifPresent(a->{
            a.setAvailableBalance(availableBalance+cash);
            accountService.updateAccount(a);
        });
    }
}
