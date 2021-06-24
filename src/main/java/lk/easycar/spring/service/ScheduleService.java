package lk.easycar.spring.service;

import lk.easycar.spring.dto.CustomerDTO;
import lk.easycar.spring.dto.ScheduleDTO;

import java.util.ArrayList;

public interface ScheduleService {

    void addShedule(ScheduleDTO scheduleDTO);

    ArrayList<ScheduleDTO> getSchedule();

    String getSid();
}
