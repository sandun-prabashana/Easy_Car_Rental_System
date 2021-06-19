package lk.easycar.spring.service.impl;

import lk.easycar.spring.dto.AdminDTO;
import lk.easycar.spring.dto.CustomerDTO;
import lk.easycar.spring.dto.DriverDTO;
import lk.easycar.spring.dto.LoginDTO;
import lk.easycar.spring.repo.AdminRepo;
import lk.easycar.spring.repo.DriverRepo;
import lk.easycar.spring.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public String GetAdminLogin(String id) {
        return adminRepo.getPassword(id);
    }

    @Override
    public String GetPasswordForANic(String id) {
        return adminRepo.getPasswordforNic(id);
    }


}
