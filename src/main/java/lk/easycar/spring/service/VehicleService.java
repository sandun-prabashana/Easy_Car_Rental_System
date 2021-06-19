package lk.easycar.spring.service;

import lk.easycar.spring.dto.AdminDTO;
import lk.easycar.spring.dto.DriverDTO;
import lk.easycar.spring.dto.VehicleDTO;

import java.util.ArrayList;

public interface VehicleService {
    void addVehicle(VehicleDTO vehicleDTO);

    ArrayList<VehicleDTO> getAllVehicle();

    void deleteVehicle(String vid);

    VehicleDTO searchVehicle(String vid);

    void updateVehicle(VehicleDTO vehicleDTO);


}
