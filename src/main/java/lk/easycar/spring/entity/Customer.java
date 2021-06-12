package lk.easycar.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    private String CID;

    @OneToOne
    @JoinColumn(name = "LID", referencedColumnName = "LID", insertable = false, updatable = false)
    private Login login;

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
