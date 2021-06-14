package lk.easycar.spring.dto;

import lk.easycar.spring.entity.Driver;
import lk.easycar.spring.entity.RequestDetail;
import lk.easycar.spring.entity.Reserved;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScheduleDTO {
    private String SID;
    private Driver driver;
    private RequestDetail requestDetail;
    private String date;
    private String statues;
}
