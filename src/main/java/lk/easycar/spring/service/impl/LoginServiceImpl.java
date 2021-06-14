package lk.easycar.spring.service.impl;

import lk.easycar.spring.dto.AdminDTO;
import lk.easycar.spring.dto.CustomerDTO;
import lk.easycar.spring.dto.DriverDTO;
import lk.easycar.spring.dto.LoginDTO;
import lk.easycar.spring.service.LoginService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Override
    public void addLogin(LoginDTO loginDTO) {

    }

}
