package lk.easycar.spring.service;

import lk.easycar.spring.dto.AdminDTO;
import lk.easycar.spring.dto.CustomerDTO;
import lk.easycar.spring.dto.DriverDTO;
import lk.easycar.spring.dto.LoginDTO;

public interface LoginService {

    String GetAdminLogin(String id);

    String GetPasswordForANic(String id);

}

