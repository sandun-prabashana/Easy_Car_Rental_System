package lk.easycar.spring.controller;

import lk.easycar.spring.service.DriverService;
import lk.easycar.spring.service.LoginService;
import lk.easycar.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginService service;

    @GetMapping(path = "go/{email}")
    public ResponseEntity searchPassword(@PathVariable String email) {
        String password = service.GetAdminLogin(email);
        return new ResponseEntity(new StandardResponse("200", "Done", password), HttpStatus.OK);
    }

    @GetMapping(path = "goNic/{email}")
    public ResponseEntity searchPasswordForNic(@PathVariable String email) {
        String password = service.GetPasswordForANic(email);
        return new ResponseEntity(new StandardResponse("200", "Done", password), HttpStatus.OK);
    }


}
