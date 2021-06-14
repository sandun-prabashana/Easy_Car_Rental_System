package lk.easycar.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reserved {
    @Id
    private String REID;

    @ManyToOne
    @JoinColumn(name = "CNic", referencedColumnName = "CNic", insertable = false, updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "reserved", cascade = CascadeType.ALL)
    private List<ReservedDetail> reservedDetail = new ArrayList<>();

}
