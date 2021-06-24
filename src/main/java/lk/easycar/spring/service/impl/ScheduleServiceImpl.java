package lk.easycar.spring.service.impl;

import lk.easycar.spring.dto.CustomerDTO;
import lk.easycar.spring.dto.RequestDetailDTO;
import lk.easycar.spring.dto.ScheduleDTO;
import lk.easycar.spring.entity.Customer;
import lk.easycar.spring.entity.RequestDetail;
import lk.easycar.spring.entity.Schedule;
import lk.easycar.spring.exception.ValidateException;
import lk.easycar.spring.repo.RequestDetailRepo;
import lk.easycar.spring.repo.ScheduleRepo;
import lk.easycar.spring.service.ScheduleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepo scheduleRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addShedule(ScheduleDTO scheduleDTO) {
        if (scheduleRepo.existsById(scheduleDTO.getSID())) {
            throw new ValidateException("Schedule AlReady Added");
        }
        scheduleRepo.save(mapper.map(scheduleDTO, Schedule.class));
    }

    @Override
    public ArrayList<ScheduleDTO> getSchedule() {
        List<Schedule> all = scheduleRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<ScheduleDTO>>() {
        }.getType());
    }

    @Override
    public String getSid() {
        return scheduleRepo.geLastSid();
    }
}
