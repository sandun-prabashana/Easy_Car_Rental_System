package lk.easycar.spring.service;

import lk.easycar.spring.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    void addCustomer(CustomerDTO customerDTO);
    ArrayList<CustomerDTO> getAllCustomers();
}
