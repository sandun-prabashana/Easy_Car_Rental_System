package lk.easycar.spring.dto;

import lk.easycar.spring.entity.Customer;
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
    private Customer customer;
    private String Vid;
    private String DriverStatus;
    private String BankSlip;
    private String PickupDate;
    private String ReturnDate;
    private String RateType;
    private double RentalFee;
    private double LDWFee;
    private String Statues;
    private String reason;
}
