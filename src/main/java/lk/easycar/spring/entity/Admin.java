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
public class Admin {
    @Id
    private String AID;

    @OneToOne
    @JoinColumn(name = "LID", referencedColumnName = "LId", insertable = false, updatable = false)
    private Login login;

    private String Name;
    private String Address;
    private String No;
    private String Nic;
}
