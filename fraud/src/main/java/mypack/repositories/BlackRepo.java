package mypack.repositories;

import mypack.models.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackRepo extends JpaRepository<BlackList,Integer> {
}
