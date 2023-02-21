package mypack.controller;

import lombok.extern.slf4j.Slf4j;
import mypack.models.CustomerRequest;
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
public class CustomerController{

    public CustomerService service;
    @PostMapping
    public void customerRegistration(@RequestBody CustomerRequest req){
        log.info("new customer registration : ",req);
        service.customerRegistration(req);
    }
}
