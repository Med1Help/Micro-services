package mypack.services;

import mypack.models.Customer;
import mypack.models.CustomerRequest;
import mypack.repositories.CustomerRepo;
import org.springframework.context.annotation.Bean;


public class CustomerService {

    CustomerRepo repo;

    public CustomerService(CustomerRepo repo) {
        this.repo = repo;
    }
    @Bean
    public void customerRegistration(CustomerRequest req){
        Customer customer = Customer.builder()
                .firstName(req.firstName())
                .lastName(req.lastName())
                .email(req.email())
                .build();
        // todo : check if email valid
        // todo : check if email taken
        repo.save(customer);
    }
}
