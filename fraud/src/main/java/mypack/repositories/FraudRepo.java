package mypack.repositories;

import mypack.models.FraudulenCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FraudRepo extends JpaRepository<FraudulenCustomer,Integer> {
    public List<FraudulenCustomer> findByIdCustomer(Integer idCustomer);
}
