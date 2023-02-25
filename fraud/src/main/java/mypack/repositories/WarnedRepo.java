package mypack.repositories;

import mypack.models.WarnedCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarnedRepo extends JpaRepository<WarnedCustomer,Integer> {
}
