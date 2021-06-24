package lk.easycar.spring.service.impl;

import lk.easycar.spring.dto.AdminDTO;
import lk.easycar.spring.dto.DriverDTO;
import lk.easycar.spring.dto.VehicleDTO;
import lk.easycar.spring.entity.Driver;
import lk.easycar.spring.entity.Vehicle;
import lk.easycar.spring.exception.ValidateException;
import lk.easycar.spring.repo.DriverRepo;
import lk.easycar.spring.repo.VehicleRepo;
import lk.easycar.spring.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void addVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getVID())) {
            throw new ValidateException("Vehicle Already Registered");
        }
        vehicleRepo.save(mapper.map(vehicleDTO, Vehicle.class));
    }

    @Override
    public ArrayList<VehicleDTO> getAllVehicle() {
        List<Vehicle> all = vehicleRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<VehicleDTO>>() {
        }.getType());
    }

    @Override
    public void deleteVehicle(String vid) {
        if (!vehicleRepo.existsById(vid)) {
            throw new ValidateException("No Vehicle for Delete");
        }
        vehicleRepo.deleteById(vid);
    }

    @Override
    public VehicleDTO searchVehicle(String vid) {
        Optional<Vehicle> vehicle = vehicleRepo.findById(vid);
        if (vehicle.isPresent()) {
            return mapper.map(vehicle.get(), VehicleDTO.class);
        }
        return null;
    }

    @Override
    public void updateVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getVID())) {
            vehicleRepo.save(mapper.map(vehicleDTO, Vehicle.class));
        }

    }

    @Override
    public void updateStatus(String state, String id) {
         vehicleRepo.updateStatus(state,id);
    }

    @Override
    public String vehicleCount(String state) {
        return vehicleRepo.vehicleCount(state);
    }

}
