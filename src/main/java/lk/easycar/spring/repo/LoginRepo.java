package lk.easycar.spring.repo;

import lk.easycar.spring.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login,String> {
}
