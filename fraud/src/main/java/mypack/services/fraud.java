package mypack.services;

import lombok.AllArgsConstructor;
import mypack.models.FraudCheck;
import mypack.models.FraudRes;
import mypack.models.FraudulenCustomer;
import mypack.repositories.FraudRepo;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class fraud {
    private final FraudRepo fraudRepo;
    private KafkaTemplate<String,String> kafkaTemplate;

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
        if(fraudulenCustomer.isEmpty()) {
            kafkaTemplate.send("mymicrofromspring/m","the customer "+customerId+" is not fraudulen");
            return new FraudCheck(false);
        }
        kafkaTemplate.send("mymicrofromspring","the customer "+fraudulenCustomer.get(0).getCustomerName()+" is fraudulen");
        return new FraudCheck(true);
    }
}
