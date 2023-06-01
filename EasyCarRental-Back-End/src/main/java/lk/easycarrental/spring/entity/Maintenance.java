package lk.easycarrental.spring.entity;

import lk.easycarrental.spring.dto.CarDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Maintenance {
    @Id
    private String maintenanceId;
    private String date;

    @ManyToOne
    @JoinColumn(name = "regNo",referencedColumnName = "regNo",nullable = false)
    private Car car;
}
