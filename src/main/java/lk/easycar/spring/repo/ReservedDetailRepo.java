package lk.easycar.spring.repo;

import lk.easycar.spring.entity.ReservedDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservedDetailRepo extends JpaRepository<ReservedDetail,String> {
}
