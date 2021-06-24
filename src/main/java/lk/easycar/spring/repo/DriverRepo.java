package lk.easycar.spring.repo;

import lk.easycar.spring.entity.Customer;
import lk.easycar.spring.entity.Driver;
import lk.easycar.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,String> {
    @Query(value = "select d.Password from Driver d where d.Email=?1")
    String getPassword(String id);

    @Query(value = "select d.Password from Driver d where d.DNic=?1")
    String getPasswordforNic(String id);

    @Query(value = "select d.DNic,d.Status from Driver d")
    List<Driver> getDriverDetail();

    @Transactional
    @Modifying
    @Query(value = "update Driver d set d.Status=?1 where d.DNic=?2")
    void updateStatus(String status,String did);

    @Query(value = "select d from Driver d where d.Email=?1")
    Driver getDriverDetailByEmail(String email);


    @Query(value = "select count(dnic) from driver where status=?1", nativeQuery = true)
    String DriverCount(String status);
}
