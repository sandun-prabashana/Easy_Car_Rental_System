package lk.easycar.spring.repo;

import lk.easycar.spring.entity.Reserved;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservedRepo extends JpaRepository<Reserved,String> {
}
