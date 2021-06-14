package lk.easycar.spring.controller;

import lk.easycar.spring.dto.CustomerDTO;
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
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
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
}
