package lk.easycar.spring.repo;

import lk.easycar.spring.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepo extends JpaRepository<Schedule,String> {
}
