package lk.easycar.spring.service;

import lk.easycar.spring.dto.CustomerDTO;
import lk.easycar.spring.dto.VehicleDTO;
import lk.easycar.spring.entity.Customer;

import java.util.ArrayList;

public interface CustomerService {
    void addCustomer(CustomerDTO customerDTO);

    ArrayList<CustomerDTO> getAllCustomers();

    boolean AlreadyExists(String id);

    String getPassword(String id);

    CustomerDTO getDetail(String id);

    CustomerDTO searchCustomer(String cid);

    String getUserCount();

}
