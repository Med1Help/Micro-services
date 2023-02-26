package mypack.services;

import mypack.models.FraudCheck;
import mypack.models.FraudRes;
import mypack.models.FraudulenCustomer;
import mypack.repositories.FraudRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class fraud {
    private final FraudRepo fraudRepo;

    public fraud(FraudRepo fraudRepo) {
        this.fraudRepo = fraudRepo;
    }
    public FraudRes addFraud(FraudulenCustomer fraudulenCustomer){
        if(!(fraudRepo.findByIdCustomer(fraudulenCustomer.getIdCustomer()).isEmpty())) return new FraudRes(fraudulenCustomer.getId(),fraudulenCustomer.getCustomerName(),fraudulenCustomer.getIdCustomer(),"already is fraudulen customer");
        FraudulenCustomer fraudulenCustomerTosave = FraudulenCustomer.builder()
                .idCustomer(fraudulenCustomer.getIdCustomer())
                .customerName(fraudulenCustomer.getCustomerName())
                .created_at(new Date())
                .updated_at(new Date())
                .build();
        int fraudId =  fraudRepo.save(
                fraudulenCustomerTosave
        ).getId();
        return new FraudRes(fraudulenCustomer.getId(),fraudulenCustomer.getCustomerName(),fraudulenCustomer.getIdCustomer(),"fraudulen saved succesfully");

    }
    public FraudCheck isFraudulen(Integer customerId){
        List<FraudulenCustomer> fraudulenCustomer = null;
        fraudulenCustomer = fraudRepo.findByIdCustomer(customerId);
        if(fraudulenCustomer.isEmpty()) return new FraudCheck(false);
        return new FraudCheck(true);
    }
}
