package lk.easycar.spring.repo;

import lk.easycar.spring.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScheduleRepo extends JpaRepository<Schedule,String> {
    @Query(value = "SELECT sID FROM Schedule ORDER BY sID DESC LIMIT 1", nativeQuery = true)
    String geLastSid();
}
