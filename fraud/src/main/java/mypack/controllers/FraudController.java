package mypack.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mypack.models.FraudCheck;
import mypack.models.FraudulenCustomer;
import org.mockito.stubbing.Answer;
import org.springframework.web.bind.annotation.*;
import mypack.repositories.FraudRepo;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RestController
@RequestMapping("api/fraud")
public class FraudController {
    private FraudRepo fraudRepo;

    public FraudController(FraudRepo fraudRepo) {
        this.fraudRepo = fraudRepo;
    }

    @GetMapping("/check/{id}")
    public FraudCheck isFraudulent(@PathVariable("id") Integer customerId){
        List<FraudulenCustomer> fraudulenCustomer = null;
        fraudulenCustomer = fraudRepo.findByIdCustomer(customerId);
        if(fraudulenCustomer.isEmpty()) return new FraudCheck(false);
        return new FraudCheck(true);
    }
}
