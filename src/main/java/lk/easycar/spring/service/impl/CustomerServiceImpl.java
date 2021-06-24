package lk.easycar.spring.service.impl;

import lk.easycar.spring.dto.CustomerDTO;
import lk.easycar.spring.dto.VehicleDTO;
import lk.easycar.spring.entity.Customer;
import lk.easycar.spring.entity.Vehicle;
import lk.easycar.spring.exception.ValidateException;
import lk.easycar.spring.repo.CustomerRepo;
import lk.easycar.spring.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCNic())) {
            throw new ValidateException("Customer Already Registered");
        }
        customerRepo.save(mapper.map(customerDTO, Customer.class));
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public boolean AlreadyExists(String id) {
        return customerRepo.existsById(id);
    }

    @Override
    public String getPassword(String id) {
        return customerRepo.getPassword(id);
    }

    @Override
    public CustomerDTO getDetail(String id) {
        Customer c= customerRepo.getCustomerDetail(id);
        return new CustomerDTO(c.getCNic(),c.getDL_No(),c.getName(),c.getAddress(),c.getPhone_No(),
                c.getEmail_Address(),c.getPassword(),c.getID_Location(),c.getDL_Location());
    }

    @Override
    public CustomerDTO searchCustomer(String cid) {
        Optional<Customer> customer = customerRepo.findById(cid);
        if (customer.isPresent()) {
            return mapper.map(customer.get(), CustomerDTO.class);
        }
        return null;
    }

    @Override
    public String getUserCount() {
        return customerRepo.userCount();
    }

//


}

