package lk.easycar.spring.dto;

import lk.easycar.spring.entity.Login;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminDTO {
    private String ANic;
    private String Name;
    private String Address;
    private String No;
    private String Email;
    private String Password;
}
