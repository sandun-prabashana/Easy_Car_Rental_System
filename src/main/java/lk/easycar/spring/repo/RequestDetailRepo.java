package lk.easycar.spring.repo;

import lk.easycar.spring.entity.RequestDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDetailRepo extends JpaRepository<RequestDetail,String> {
}
