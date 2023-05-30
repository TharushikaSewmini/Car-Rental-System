package lk.easycarrental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Driver {
    @Id
    private String driverId;
    private String driverName;
    private String driverContact;
    private String driverUsername;
    private String driverPassword;
    private String driverStatus;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    private List<Booking> booking;
}
