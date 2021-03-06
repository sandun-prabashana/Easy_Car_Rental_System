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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
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

    @PutMapping(path = "/update")
    public ResponseEntity updateDriver(@RequestBody VehicleDTO vehicleDTO) {
        if (vehicleDTO.getVID().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        service.updateVehicle(vehicleDTO);
        return new ResponseEntity(new StandardResponse("200", "Done", vehicleDTO), HttpStatus.OK);
    }

//    @PostMapping("/uploadfile")
//    public ResponseEntity uploadImage(@RequestPart("file") MultipartFile multipartFile) {
//
//        System.out.println(multipartFile.getOriginalFilename());
//        try {
//            String projectpath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
//
//            File uploadsDir = new File(projectpath + "/uploads");
//            uploadsDir.mkdir();
//
//            multipartFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + multipartFile.getOriginalFilename()));
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String filepath = "E:\\Easy_Car_System\\Spring Final Project\\target\\Spring Final Project-1.0.0\\uploads\\" + multipartFile.getOriginalFilename();
//
//        StandardResponse standardResponse = new StandardResponse("200", "Success!", filepath);
//        return new ResponseEntity(standardResponse, HttpStatus.OK);
//    }

    @PutMapping(path = "/{state}/{vid}")
    public ResponseEntity updateState(@PathVariable String state,@PathVariable String vid ) {
        service.updateStatus(state,vid);
        return new ResponseEntity(new StandardResponse("200", "Done", state), HttpStatus.OK);
    }

    @GetMapping(path = "count/{state}")
    public ResponseEntity bookingCount(@PathVariable String state) {
        String booking = service.vehicleCount(state);
        return new ResponseEntity(new StandardResponse("200", "Done", booking), HttpStatus.OK);
    }

}
