package lk.easycar.spring.repo;

import lk.easycar.spring.entity.RequestDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface RequestDetailRepo extends JpaRepository<RequestDetail,String> {

    @Query(value = "SELECT rID FROM RequestDetail ORDER BY rID DESC LIMIT 1", nativeQuery = true)
    String geLastRid();

    @Transactional
    @Modifying
    @Query(value = "update RequestDetail r set r.Statues=?1 where r.RID=?2")
    void updateStatus(String status,String rid);



    @Query(value = "select count(rID) from RequestDetail where requestDate=?1", nativeQuery = true)
    String BookingCount(String date);

    @Transactional
    @Modifying
    @Query(value = "update RequestDetail r set r.reason=?1 where r.RID=?2")
    void updateReasone(String reason,String rid);
}
