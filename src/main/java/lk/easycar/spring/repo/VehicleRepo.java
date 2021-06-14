package lk.easycar.spring.repo;

import lk.easycar.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {

}
