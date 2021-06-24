package lk.easycar.spring.service.impl;

import lk.easycar.spring.dto.CustomerDTO;
import lk.easycar.spring.dto.RequestDetailDTO;
import lk.easycar.spring.entity.Customer;
import lk.easycar.spring.entity.RequestDetail;
import lk.easycar.spring.exception.ValidateException;
import lk.easycar.spring.repo.AdminRepo;
import lk.easycar.spring.repo.RequestDetailRepo;
import lk.easycar.spring.service.RequestService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestDetailRepo requestDetailRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public String getRid() {
        return requestDetailRepo.geLastRid();
    }

    @Override
    public void addRequest(RequestDetailDTO requestDetailDTO) {
        if (requestDetailRepo.existsById(requestDetailDTO.getRID())) {
            throw new ValidateException("Request is already in the system..");
        } else {
            RequestDetail request = mapper.map(requestDetailDTO, RequestDetail.class);
            requestDetailRepo.save(request);
        }
    }

    @Override
    public ArrayList<RequestDetailDTO> getAllRequest() {
        List<RequestDetail> all = requestDetailRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<RequestDetailDTO>>() {
        }.getType());
    }

    @Override
    public void updateStatus(String status, String rid) {
        requestDetailRepo.updateStatus(status, rid);
    }

    @Override
    public String bookingCount(String date) {
        return requestDetailRepo.BookingCount(date);
    }

    @Override
    public void UpdateReason(String reason, String rid) {
        requestDetailRepo.updateReasone(reason, rid);
    }
}