package lk.easycar.spring.service;

import lk.easycar.spring.dto.CustomerDTO;
import lk.easycar.spring.dto.DriverDTO;
import lk.easycar.spring.dto.VehicleDTO;

import java.util.ArrayList;

public interface DriverService {
    void addDriver(DriverDTO driverDTO);

    ArrayList<DriverDTO> getAllDrivers();

    void updateDriver(DriverDTO driverDTO);

    String GetDriverPassword(String id);

    String GetPasswordForDNic(String id);

    DriverDTO searchDriver(String did);

    void updateStatus(String status,String did);

    DriverDTO searchDriverbyEmail(String email);

    String DriverCount(String state);
}
