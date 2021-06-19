package lk.easycar.spring.repo;

import lk.easycar.spring.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Admin,String> {
    @Query(value = "select a.Password from Admin a where a.Email=?1")
    String getPassword(String id);


    @Query(value = "select a.Password from Admin a where a.ANic=?1")
    String getPasswordforNic(String id);
}
