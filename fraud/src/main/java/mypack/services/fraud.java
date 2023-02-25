package mypack.services;

import mypack.models.FraudRes;
import mypack.models.FraudulenCustomer;
import mypack.repositories.FraudRepo;
import org.springframework.stereotype.Service;

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
                .build();
        int fraudId =  fraudRepo.save(
                fraudulenCustomerTosave
        ).getId();
        return new FraudRes(fraudulenCustomer.getId(),fraudulenCustomer.getCustomerName(),fraudulenCustomer.getIdCustomer(),"fraudulen saved succesfully");

    }
    public boolean isFraudulen(Integer customerId){
        List<FraudulenCustomer> fraudulenCustomers = fraudRepo.findByIdCustomer(customerId);
        if(fraudulenCustomers.isEmpty()) return false;
        return true;
    }
}
