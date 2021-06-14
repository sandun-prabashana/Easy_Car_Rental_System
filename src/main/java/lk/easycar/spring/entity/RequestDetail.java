package lk.easycar.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestDetail {
    @Id
    private String RID;

    @ManyToOne
    @JoinColumn(name = "CNic", referencedColumnName = "CNic", insertable = false, updatable = false)
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
