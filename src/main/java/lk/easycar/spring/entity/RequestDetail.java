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
    @JoinColumn(name = "CNic")
    private Customer customer;

    private String Vid;

    @ManyToOne
    @JoinColumn(name = "DNic")
    private Driver driver;

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
