package lk.easycar.spring.controller;


import lk.easycar.spring.dto.CustomerDTO;
import lk.easycar.spring.dto.ScheduleDTO;
import lk.easycar.spring.exception.NotFoundException;
import lk.easycar.spring.service.RequestService;
import lk.easycar.spring.service.ScheduleService;
import lk.easycar.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/schedule")
@CrossOrigin
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @GetMapping()
    public ResponseEntity searchRID() {
        String rid = service.getSid();
        return new ResponseEntity(new StandardResponse("200", "Done", rid), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity saveSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        if (scheduleDTO.getSID().trim().length() <= 0) {
            throw new NotFoundException("Schedule Id cannot be empty");
        }
        service.addShedule(scheduleDTO);
        return new ResponseEntity(new StandardResponse("201", "Done", scheduleDTO), HttpStatus.CREATED);
    }

    @GetMapping(path = "/getall")
    public ResponseEntity getAllSchedule() {
        ArrayList<ScheduleDTO> allSchedule = service.getSchedule();
        return new ResponseEntity(new StandardResponse("200", "Done", allSchedule), HttpStatus.OK);
    }
}
