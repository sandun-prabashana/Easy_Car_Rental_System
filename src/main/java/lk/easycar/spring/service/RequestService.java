package lk.easycar.spring.service;

import lk.easycar.spring.dto.CustomerDTO;
import lk.easycar.spring.dto.RequestDetailDTO;

import java.util.ArrayList;

public interface RequestService {
    String getRid();

    void addRequest(RequestDetailDTO requestDetailDTO);

    ArrayList<RequestDetailDTO> getAllRequest();

    void updateStatus(String status,String rid);


    String bookingCount(String date);

    void UpdateReason(String reason,String rid);


}
