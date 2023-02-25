package mypack.services;

import mypack.models.Customer;
import mypack.models.CustomerRequest;
import mypack.models.CustomerRes;
import mypack.models.FraudCheck;
import mypack.repositories.CustomerRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    CustomerRepo repo;
    private final RestTemplate restTemplate;
    public CustomerService(CustomerRepo repo, RestTemplate restTemplate) {
        this.repo = repo;
        this.restTemplate = restTemplate;
    }

    public CustomerRes customerRegistration(CustomerRequest req){
        Customer customer = Customer.builder()
                .firstName(req.firstName())
                .lastName(req.lastName())
                .email(req.email())
                .build();
        // checking email
        if(!(req.email().contains("@")))return  new CustomerRes("",0,"email invalid");
        if(!(repo.findByEmail(req.email()).isEmpty()))return  new CustomerRes("",0,"email taken");
        repo.saveAndFlush(customer);
        int checkId = customer.getId();
        return new CustomerRes(req.firstName()+" "+req.lastName(),checkId,"registration succesfully");
    }
    public CustomerRes customerLoggining(Integer id){
        //TODO integrate fraud checking in security later
        FraudCheck res = restTemplate.getForObject(
                "http://localhost:8082/api/fraud/check/{id}",
                FraudCheck.class,
                id
                );
        //TODO update login with spring security
        if(res.isFraudulen()){
            return new CustomerRes("",0,"Login failed because you are fraudster customer");
        }
        return new CustomerRes("",0,"Login succesfully");
    }
}
