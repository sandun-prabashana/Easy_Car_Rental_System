package lk.easycar.spring.controller;

import lk.easycar.spring.dto.CustomerDTO;
import lk.easycar.spring.dto.DriverDTO;
import lk.easycar.spring.dto.VehicleDTO;
import lk.easycar.spring.entity.Driver;
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

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDriver(@RequestBody DriverDTO driverDTO) {
        if (driverDTO.getDNic().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        service.updateDriver(driverDTO);
        return new ResponseEntity(new StandardResponse("200", "Done", driverDTO), HttpStatus.OK);
    }

    @GetMapping(path = "go/{email}")
    public ResponseEntity searchPassword(@PathVariable String email) {
        String password = service.GetDriverPassword(email);
        return new ResponseEntity(new StandardResponse("200", "Done", password), HttpStatus.OK);
    }

    @GetMapping(path = "goNic/{email}")
    public ResponseEntity searchPasswordForNic(@PathVariable String email) {
        String password = service.GetPasswordForDNic(email);
        return new ResponseEntity(new StandardResponse("200", "Done", password), HttpStatus.OK);
    }

    @GetMapping(path = "search/{did}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchCustomer(@PathVariable String did) {
        DriverDTO driverDTO = service.searchDriver(did);
        return new ResponseEntity(new StandardResponse("200", "Done", driverDTO), HttpStatus.OK);
    }

    @PutMapping(path = "status/{state}/{vid}")
    public ResponseEntity updateState(@PathVariable String state,@PathVariable String vid ) {
        service.updateStatus(state,vid);
        return new ResponseEntity(new StandardResponse("200", "Done", state), HttpStatus.OK);
    }

    @GetMapping(path = "need/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchDriver(@PathVariable String email) {
        DriverDTO driverDTO=service.searchDriverbyEmail(email);
        return new ResponseEntity(new StandardResponse("200", "Done", driverDTO), HttpStatus.OK);
    }

    @GetMapping(path = "count/{state}")
    public ResponseEntity DriverCount(@PathVariable String state) {
        String driver = service.DriverCount(state);
        return new ResponseEntity(new StandardResponse("200", "Done", driver), HttpStatus.OK);
    }
}
