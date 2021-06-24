package lk.easycar.spring.repo;

import lk.easycar.spring.entity.Reserved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservedRepo extends JpaRepository<Reserved,String> {

}
