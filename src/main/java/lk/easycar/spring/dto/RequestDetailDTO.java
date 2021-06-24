package lk.easycar.spring.dto;

import lk.easycar.spring.entity.Customer;
import lk.easycar.spring.entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestDetailDTO {

    private String RID;
    private CustomerDTO customer;
    private String Vid;
    private DriverDTO driver;
    private String BankSlip;
    private String RequestDate;
    private String PickupDate;
    private String ReturnDate;
    private String RateType;
    private double RentalFee;
    private double LDWFee;
    private String Statues;
    private String reason;
}
