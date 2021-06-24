package lk.easycar.spring.repo;

import lk.easycar.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {

//    @Query(value = "update Vehicle v set v.Status=:Status where v.VID=:VID")
//    void updateStatus(@Param("Status") String Status, @Param("VID") String VID);

    @Transactional
    @Modifying
    @Query(value = "update Vehicle v set v.Status=?1 where v.VID=?2")
    void updateStatus(String status,String vid);

    @Query(value = "select count(vid) from Vehicle where status=?1", nativeQuery = true)
    String vehicleCount(String status);

}
