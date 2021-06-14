package lk.easycar.spring.controller;

import lk.easycar.spring.dto.CustomerDTO;
import lk.easycar.spring.dto.DriverDTO;
import lk.easycar.spring.exception.NotFoundException;
import lk.easycar.spring.service.CustomerService;
import lk.easycar.spring.service.DriverService;
import lk.easycar.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {
    @Autowired
    private DriverService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveCustomer(@RequestBody DriverDTO driverDTO) {
        if (driverDTO.getDNic().trim().length() <= 0) {
            throw new NotFoundException("Driver NIC cannot be empty");
        }
        service.addDriver(driverDTO);
        return new ResponseEntity(new StandardResponse("201", "Done", driverDTO), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllDrivers() {
        ArrayList<DriverDTO> allDrivers = service.getAllDrivers();
        return new ResponseEntity(new StandardResponse("200", "Done", allDrivers), HttpStatus.OK);
    }
}
