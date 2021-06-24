package lk.easycar.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Schedule {
    @Id
    private String SID;

    @ManyToOne
    @JoinColumn(name = "DNic")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "RID")
    private RequestDetail requestDetail;

    private String date;
    private String statues;
}
