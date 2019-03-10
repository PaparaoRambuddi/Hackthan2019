package com.dbs.hack2hire.group7.accountService.controller;



import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.hack2hire.group7.accountService.controller.entity.Customer;
import com.dbs.hack2hire.group7.accountService.controller.entity.Transaction;
import com.dbs.hack2hire.group7.accountService.repository.AccountRepository;
import com.dbs.hack2hire.group7.accountService.repository.CustomerRepository;
import com.dbs.hack2hire.group7.accountService.repository.TransactionRepository;
import com.dbs.hack2hire.group7.accountService.service.AccountService;
import com.dbs.hack2hire.group7.accountService.service.AccountServiceImpl;
import com.dbs.hack2hire.group7.accountService.service.CustomerService;
import com.dbs.hack2hire.group7.accountService.service.CustomerServiceImpl;
import com.dbs.hack2hire.group7.accountService.service.PushNotificationService;
import com.dbs.hack2hire.group7.accountService.service.TransactionService;
import com.dbs.hack2hire.group7.accountService.service.TransactionServiceImpl;
@RestController/*("/Transaction/")*/
public class TransactionController {
	private final Logger log = LoggerFactory.getLogger(TransactionController.class);	
	@Autowired
	private TransactionController TransactionController;
	
	   
	   @Autowired
	   private Transaction transaction;
	   private String DEVICE_KEY=null;
	   
	   @Autowired
	   private CustomerService customerService;
	   
	   
	   @Autowired
	   private CustomerRepository customerRepository;
	   @Autowired
	   private TransactionService transactionService;
	   
	  
	   @Autowired
	   private TransactionRepository transactionRepository;
	   
	   
	   @Autowired
	   private AccountService accountService;
	   @Autowired
	   private AccountRepository accountRepository;
	   
	   @Autowired
	    PushNotificationService androidPushNotificationsService;
	   
	   @Bean
		public PushNotificationService getPushNotificationService() {
		   return new PushNotificationService();
		}
	   
		@Bean
		public CustomerService getCustomerService() {
		   return new CustomerServiceImpl(customerRepository);
		}
		
		@Bean
		public Transaction getTransaction() {
		   return new Transaction();
		}
		
		
		@Bean
		public TransactionService getTransactionService() {
		   return new TransactionServiceImpl(transactionRepository);
		}
		
		@Bean
		public AccountService getAccountService() {
		   return new AccountServiceImpl(accountRepository);
		}
		
	 @RequestMapping(value = "/processTransaction", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	   public  @ResponseBody Transaction processTransaction(@RequestBody Transaction transaction) {	
		System.out.println("Account ID" +transaction.getAccount_id());
		DEVICE_KEY=transaction.getDevice_key();
		boolean isDone=false;
		/* if (errors.hasErrors()) {
	            return new ResponseEntity<>(new ErrorResponse(CREATE_TRANSACTION_ERROR.getId(), CREATE_TRANSACTION_ERROR.getMessage()), HttpStatus.BAD_REQUEST);
	        }
		*/ 
		
		Optional<Customer> customer = customerService.findCustomerById(transaction.getCustomer_id());
		if(customer!=null) {
		
		 isDone = accountService.initateTransaction(transaction.getBank_account_from() ,transaction.getBank_account_to(),transaction.getTransaction_amount());
		 //customerService.updateReedamPoints(rewardsPoints, customerId)
		}
        if(isDone) {
            transaction.setStatus("SUCCESS");
            
        	transaction.setReward_jack_point((long)transaction.getTransaction_amount());
        }
        else
            transaction.setStatus("FAILED");
        
        Transaction Successtrasaction = transactionService.saveTransaction(transaction); 
        if(Successtrasaction!=null && Successtrasaction.getAccount_id()!=null) {
        	System.out.println("rewards points" +(transaction.getReward_jack_point()+ customer.get().getRewardsPoints()));
        	customerService.updateReedamPoints((transaction.getReward_jack_point()+ customer.get().getRewardsPoints()), transaction.getCustomer_id());
        	try {
        		send();
        	}catch (Exception e) {
				// TODO: handle exception
        		log.error(e.getMessage());
			}
        	
        }else {
        	accountService.initateTransaction(transaction.getBank_account_to(),transaction.getBank_account_from(),transaction.getTransaction_amount());
        }
        
		// }
		  
	      return transaction;
	   }
	 
	 @RequestMapping(value = "/TransactionHistory/{account_id}", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Transaction> getTransactionHistory(@PathVariable("account_id")String account_id) {
		
		 return transactionService.getTransactionHistory(account_id);
	 }
	 
	 @RequestMapping(value = "/send", method = RequestMethod.GET, produces = "application/json")
	    public ResponseEntity<String> send() throws JSONException {

	        /*JSONObject body = new JSONObject();
	        body.put("to", DEVICE_KEY);
	        body.put("collapse_key", "type_a");
	        body.put("notification","Redemption Points");

	        JSONObject data = new JSONObject();
	        data.put("title", "DBS Redemption Jack Points");
	        data.put("body", "Welcome to Jack Point!");
	        data.put("Key-1", "Data 1");
	        data.put("Key-2", "Data 2");

	        body.put("data", data);

	        HttpEntity<String> request = new HttpEntity<>(body.toString());*/

	        try {
	            String pushNotification = androidPushNotificationsService.sendPushNotification(DEVICE_KEY, "Hello!","Welcome!!!");

	            return new ResponseEntity<>(pushNotification, HttpStatus.OK);
	        } catch (IOException e) {
	        }
	        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
	    }
	 
}