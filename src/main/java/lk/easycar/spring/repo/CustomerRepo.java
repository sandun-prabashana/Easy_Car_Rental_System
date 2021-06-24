package lk.easycar.spring.repo;

import lk.easycar.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface CustomerRepo extends JpaRepository<Customer,String> {
    @Query(value = "select c.Password from Customer c where c.Email_Address=?1")
    String getPassword(String id);

    @Query(value = "select c from Customer c where c.Email_Address=?1")
    Customer getCustomerDetail(String id);

    @Query(value = "SELECT COUNT(cnic) FROM Customer", nativeQuery = true)
    String userCount();



}
