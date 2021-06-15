package lk.easycar.spring.service.impl;

import lk.easycar.spring.dto.CustomerDTO;
import lk.easycar.spring.dto.DriverDTO;
import lk.easycar.spring.entity.Customer;
import lk.easycar.spring.entity.Driver;
import lk.easycar.spring.entity.Vehicle;
import lk.easycar.spring.exception.ValidateException;
import lk.easycar.spring.repo.CustomerRepo;
import lk.easycar.spring.repo.DriverRepo;
import lk.easycar.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addDriver(DriverDTO driverDTO) {
        if (driverRepo.existsById(driverDTO.getDNic())) {
            throw new ValidateException("Driver Already Registered");
        }
        driverRepo.save(mapper.map(driverDTO, Driver.class));
    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        List<Driver> all = driverRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<DriverDTO>>() {
        }.getType());
    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {
        if (driverRepo.existsById(driverDTO.getDNic())) {
            driverRepo.save(mapper.map(driverDTO, Driver.class));
        }
    }
}
