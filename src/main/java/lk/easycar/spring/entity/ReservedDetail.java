package lk.easycar.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservedDetail {

    @EmbeddedId
    private Reserves_Vehicle_PK  pk;

    @ManyToOne
    @JoinColumn(name = "REID", referencedColumnName = "REID", insertable = false, updatable = false)
    private Reserved reserved;

    @ManyToOne
    @JoinColumn(name = "VID", referencedColumnName = "VID", insertable = false, updatable = false)
    private Vehicle vehicle;

    private double RentalFee;
    private double LDWFee;
    private int KmCount;
    private double TotalFee;
    private String bankSlip;



}
