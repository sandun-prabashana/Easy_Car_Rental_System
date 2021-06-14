package lk.easycar.spring.dto;

import lk.easycar.spring.entity.Customer;
import lk.easycar.spring.entity.ReservedDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservedDTO {
    private String REID;
    private Customer customer;
    private List<ReservedDetail> reservedDetail = new ArrayList<>();

}
