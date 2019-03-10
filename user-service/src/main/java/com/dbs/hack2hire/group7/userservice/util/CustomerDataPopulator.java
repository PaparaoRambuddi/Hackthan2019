package com.dbs.hack2hire.group7.userservice.util;

import com.dbs.hack2hire.group7.userservice.controller.entity.Customer;
import com.dbs.hack2hire.group7.userservice.repository.CustomerRepository;
import org.joda.time.DateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class CustomerDataPopulator implements CommandLineRunner {
    private CustomerRepository customerRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
    public CustomerDataPopulator(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        String userArray[] = new String[]{
            "100,Andrew,1991-05-23,F3325690M,89453078,sasithaniranjana@gmail.com,1000-5000,Senior Sofware Engineer,Senkang,Senkang,27,ERTYuidsf,true,false,10",
            "111,Saman,1990-06-27,F3324567M,88453078,saman@gmail.com,4000-5000,Test Engineer,Habourfront,Harbourfront,28,ESDFghjui,true,true,5",
            "121,Sajith,1993-06-27,F3225567M,88454078,sajith@gmail.com,2000-5000,Civil Engineer,Boonlay,Boonlay,29,QWertyui,true,false,4",
            "123,Arya Stark,1996-06-27,H3225567M,78454078,arya@gmail.com,2500-5000,Android Engineer,Serangoon,Serangoon,31,QAZswer,false,false,40",
        };
        /*Customer customer = new Customer();
        customer.setName("Sasitha Niranjana");
        customer.setDateOfBirth(DateTime.now().toDate());
        customer.setDocumentId("F3325690M");
        customer.setPhoneNumber("89453078");
        customer.setEmail("sasithaniranjana@gmail.com");
        customer.setIncomeRange("1000-5000");
        customer.setOccupation("Senior Sofware Engineer");
        customer.setResidentialAddress("Senkang");
        customer.setCommunicationAddress("Senkang");
        customer.setAge(25);
        customer.setIsMale(true);
        customer.setIsSingle(false);
        customer.setRewardsPoints(5l);
        customer.setPassword("password");
        this.customerRepository.save(customer);*/
        //Stream.of(userArray).forEach(s->saveUser(s));
    }

    private void saveUser(String s){
        String a[]=s.split(",");
        Customer customer = new Customer();
        customer.setId(Long.valueOf(a[0]));
        customer.setName(a[1]);
        customer.setDateOfBirth(DateTime.parse(a[2]).toDate());
        customer.setDocumentId(a[3]);
        customer.setPhoneNumber(a[4]);
        customer.setEmail(a[5]);
        customer.setIncomeRange(a[6]);
        customer.setOccupation(a[7]);
        customer.setResidentialAddress(a[8]);
        customer.setCommunicationAddress(a[9]);
        customer.setAge(Integer.valueOf(a[10]));
        customer.setPassword(a[11]);
        customer.setIsMale(Boolean.valueOf(a[12]));
        customer.setIsSingle(Boolean.valueOf(a[13]));
        customer.setRewardsPoints(Long.valueOf(a[14]));
        this.customerRepository.saveAndFlush(customer);
    }
}
