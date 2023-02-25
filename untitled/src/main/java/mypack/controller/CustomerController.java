package mypack.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mypack.models.CustomerRequest;
import mypack.models.CustomerRes;
import mypack.repositories.CustomerRepo;
import mypack.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController{

    public CustomerService service;
    private final CustomerRepo repo ;
    @PostMapping
    public CustomerRes customerRegistration(@RequestBody CustomerRequest req){
        log.info("new customer registration : ",req);
        return service.customerRegistration(req);
    }
    @PostMapping("login")
    public CustomerRes customerlogging(@RequestBody CustomerRequest req){
        Integer customerId = null;
            customerId = repo.findByEmail(req.email()).get(0).getId();
        if( customerId == null ){
            return new CustomerRes("",0,"email invalid");
        }
        log.info("new customer login : ",req);
        CustomerRes res = service.customerLoggining(customerId);
        return res;
    }
}
