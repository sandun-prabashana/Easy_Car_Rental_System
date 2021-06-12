package lk.easycar.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDetailDTO {
    private String CDID;
    private String ID_No;
    private String DL_No;
    private String Name;
    private String Address;
    private Integer Phone_No;
    private String Email_Address;
    private String Password;
    private String ID_Location;
    private String DL_Location;

}
