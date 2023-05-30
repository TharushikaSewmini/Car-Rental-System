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
public class Car {
    @Id
    private String regNo;
    private String brand;
    private String type;
    private int noOfPassengers;
    private String transmissionType;
    private String fuelType;
    private String color;
    private double dailyRate;
    private double monthlyRate;
    private double lossDamageWaiver;
    private double freeKMForDay;
    private double freeKMForMonth;
    private double priceForExtraKM;
    private String status;
//    private double completedKM;

//    @OneToMany(mappedBy = "cars",cascade = CascadeType.ALL)
//    private List<Image> image;

    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    private List<Booking> booking;
}
