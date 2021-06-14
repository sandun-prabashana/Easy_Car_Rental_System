package lk.easycar.spring.controller;


import lk.easycar.spring.dto.CustomerDTO;
import lk.easycar.spring.dto.DriverDTO;
import lk.easycar.spring.dto.VehicleDTO;
import lk.easycar.spring.exception.NotFoundException;
import lk.easycar.spring.service.CustomerService;
import lk.easycar.spring.service.VehicleService;
import lk.easycar.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class VechicleController {
    @Autowired
    private VehicleService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveCustomer(@RequestBody VehicleDTO vehicleDTO) {
        if (vehicleDTO.getVID().trim().length() <= 0) {
            throw new NotFoundException("Vehicle Id cannot be empty");
        }
        service.addVehicle(vehicleDTO);
        return new ResponseEntity(new StandardResponse("201", "Done", vehicleDTO), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllVehicle() {
        ArrayList<VehicleDTO> allVehicles = service.getAllVehicle();
        return new ResponseEntity(new StandardResponse("200", "Done", allVehicles), HttpStatus.OK);
    }

    @GetMapping(path = "/{vid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchVehicle(@PathVariable String vid) {
        VehicleDTO vehicleDTO = service.searchVehicle(vid);
        return new ResponseEntity(new StandardResponse("200", "Done", vehicleDTO), HttpStatus.OK);
    }

    @DeleteMapping(params = {"vid"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteVehicleCustomer(@RequestParam String vid) {
        service.deleteVehicle(vid);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDriver(@RequestBody VehicleDTO vehicleDTO) {
        if (vehicleDTO.getVID().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        service.updateVehicle(vehicleDTO);
        return new ResponseEntity(new StandardResponse("200", "Done", vehicleDTO), HttpStatus.OK);
    }
}
