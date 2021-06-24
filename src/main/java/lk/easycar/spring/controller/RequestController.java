package lk.easycar.spring.controller;

import lk.easycar.spring.dto.CustomerDTO;
import lk.easycar.spring.dto.RequestDetailDTO;
import lk.easycar.spring.exception.NotFoundException;
import lk.easycar.spring.service.LoginService;
import lk.easycar.spring.service.RequestService;
import lk.easycar.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/request")
@CrossOrigin
public class RequestController {
    @Autowired
    private RequestService service;

    @GetMapping()
    public ResponseEntity searchRID() {
        String rid = service.getRid();
        return new ResponseEntity(new StandardResponse("200", "Done", rid), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity postRequest(@RequestBody RequestDetailDTO dto) {
        service.addRequest(dto);
        return new ResponseEntity(new StandardResponse("200", "Request has been sent", dto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/allreq")
    public ResponseEntity getAllReqDetail() {
        ArrayList<RequestDetailDTO> allReq = service.getAllRequest();
        return new ResponseEntity(new StandardResponse("200", "Done", allReq), HttpStatus.OK);
    }

    @PutMapping(path = "status/{state}/{rid}")
    public ResponseEntity updateState(@PathVariable String state,@PathVariable String rid ) {
        service.updateStatus(state,rid);
        return new ResponseEntity(new StandardResponse("200", "Done", state), HttpStatus.OK);
    }

    @GetMapping(path = "count/{date}")
    public ResponseEntity bookingCount(@PathVariable String date) {
        String booking = service.bookingCount(date);
        return new ResponseEntity(new StandardResponse("200", "Done", booking), HttpStatus.OK);
    }

    @PutMapping(path = "reason/{reason}/{rid}")
    public ResponseEntity updateReason(@PathVariable String reason,@PathVariable String rid ) {
        service.UpdateReason(reason, rid);
        return new ResponseEntity(new StandardResponse("200", "Done", reason), HttpStatus.OK);
    }
}
