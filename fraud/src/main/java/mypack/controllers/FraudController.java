package mypack.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mypack.models.FraudCheck;
import mypack.models.FraudRes;
import mypack.models.FraudulenCustomer;
import org.mockito.stubbing.Answer;
import org.springframework.web.bind.annotation.*;
import mypack.repositories.FraudRepo;
import mypack.services.fraud;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RestController
@RequestMapping("/fraud")
@AllArgsConstructor
public class FraudController {

    private final fraud fraudService;

    @GetMapping("/check/{id}")
    public FraudCheck isFraudulent(@PathVariable("id") Integer customerId){

        return fraudService.isFraudulen(customerId);
    }
    @PostMapping("/add")
    public FraudRes addFraudulen(@RequestBody FraudulenCustomer fraudulenCustomer){
        return fraudService.addFraud(fraudulenCustomer);
    }
}
