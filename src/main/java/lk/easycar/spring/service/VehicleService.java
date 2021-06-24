package lk.easycar.spring.service;

import lk.easycar.spring.dto.AdminDTO;
import lk.easycar.spring.dto.DriverDTO;
import lk.easycar.spring.dto.VehicleDTO;
import lk.easycar.spring.entity.Driver;

import java.util.ArrayList;
import java.util.List;

public interface VehicleService {
    void addVehicle(VehicleDTO vehicleDTO);

    ArrayList<VehicleDTO> getAllVehicle();

    void deleteVehicle(String vid);

    VehicleDTO searchVehicle(String vid);

    void updateVehicle(VehicleDTO vehicleDTO);

    void updateStatus(String state,String id);

    String vehicleCount(String state);

}
