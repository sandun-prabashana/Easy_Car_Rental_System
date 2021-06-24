package lk.easycar.spring.controller;

import lk.easycar.spring.dto.CustomerDTO;
import lk.easycar.spring.dto.VehicleDTO;
import lk.easycar.spring.entity.Customer;
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
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping(path = "/regUser")
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO customerDTO) {
        if (customerDTO.getCNic().trim().length() <= 0) {
            throw new NotFoundException("Customer NIC cannot be empty");
        }
        service.addCustomer(customerDTO);
        return new ResponseEntity(new StandardResponse("201", "Done", customerDTO), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCustomers() {
        ArrayList<CustomerDTO> allCustomers = service.getAllCustomers();
        return new ResponseEntity(new StandardResponse("200", "Done", allCustomers), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity uploadImage(@RequestPart("file") MultipartFile multipartFile) {

        System.out.println(multipartFile.getOriginalFilename());
        try {
            String projectpath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();

            File uploadsDir = new File(projectpath + "/uploads");
            uploadsDir.mkdir();

            multipartFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + multipartFile.getOriginalFilename()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filepath = "E:/Easy_Car_System/Spring Final Project/target/Spring Final Project-1.0.0/uploads/" + multipartFile.getOriginalFilename();

        StandardResponse standardResponse = new StandardResponse("200", "Success!", filepath);
        return new ResponseEntity(standardResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/{email}")
    public ResponseEntity searchPassword(@PathVariable String email) {
        String password = service.getPassword(email);
        return new ResponseEntity(new StandardResponse("200", "Done", password), HttpStatus.OK);
    }

    @GetMapping(path = "need/{custid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchVehicle(@PathVariable String custid) {
        CustomerDTO customerDTO = service.getDetail(custid);
        return new ResponseEntity(new StandardResponse("200", "Done", customerDTO), HttpStatus.OK);
    }

    @GetMapping(path = "search/{cid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchCustomer(@PathVariable String cid) {
        CustomerDTO customerDTO = service.searchCustomer(cid);
        return new ResponseEntity(new StandardResponse("200", "Done", customerDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/count")
    public ResponseEntity searchRID() {
        String count= service.getUserCount();
        return new ResponseEntity(new StandardResponse("200", "Done", count), HttpStatus.OK);
    }

}
