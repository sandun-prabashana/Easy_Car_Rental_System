package lk.easycar.spring.dto;

import lk.easycar.spring.entity.Reserved;
import lk.easycar.spring.entity.Reserves_Vehicle_PK;
import lk.easycar.spring.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservedDetailDTO {
    private Reserves_Vehicle_PK pk;
    private Reserved reserved;
    private Vehicle vehicle;
    private double RentalFee;
    private double LDWFee;
    private int KmCount;
    private double TotalFee;
    private String bankSlip;
}
