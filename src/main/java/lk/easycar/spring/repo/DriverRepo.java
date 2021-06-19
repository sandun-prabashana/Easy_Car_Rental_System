package lk.easycar.spring.repo;

import lk.easycar.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepo extends JpaRepository<Driver,String> {
    @Query(value = "select d.Password from Driver d where d.Email=?1")
    String getPassword(String id);

    @Query(value = "select d.Password from Driver d where d.DNic=?1")
    String getPasswordforNic(String id);
}
