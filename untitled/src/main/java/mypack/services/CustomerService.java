package mypack.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mypack.models.*;
import mypack.repositories.CustomerRepo;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.*;
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
                "http://FRAUD/fraud/check/{id}",
                FraudCheck.class,
                id
                );
        //TODO update login with spring security
        if(res.isFraudulen()){
            return new CustomerRes("",0,"Login failed because you are fraudster customer");
        }
        return new CustomerRes("",0,"Login succesfully");
    }
    public CustomerRes addToFraud(FraudulenCustomer fraudulenCustomer) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","XXXXXX");
        String json = new ObjectMapper().writeValueAsString(fraudulenCustomer);
        HttpEntity entity = new HttpEntity(json,headers);
        ResponseEntity<FraudRes> res = restTemplate.exchange("http://FRAUD_SERVICE/api/fraud/add", HttpMethod.POST,entity,FraudRes.class);
        if(res.getBody().getRes().contains("succesfully")) return new CustomerRes(
                res.getBody().getCustomerName(),res.getBody().getIdCustomer(),res.getBody().getRes()
        );
        return new CustomerRes("",0,"can't add to fraudulen ");
    }
}
