package lk.easycar.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleDTO {
    private String VID;
    private String Brand;
    private String Type;
    private String Category;
    private String Front_Image;
    private int No_Of_Passenger;
    private String Transmission_Type;
    private String Fuel_Type;
    private double Daily_Rate;
    private double Monthly_Rate;
    private double Free_Km_For_Day;
    private double Free_Km_For_Month;
    private double Extra_Km_Price;
    private String Color;
    private int Total_Km;
    private String Status;
}
