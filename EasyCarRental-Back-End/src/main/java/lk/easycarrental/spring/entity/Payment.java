package lk.easycarrental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int paymentId;
    private String paymentDate;
    private double amount;

    @OneToOne
    @JoinColumn(name = "bookingId",referencedColumnName = "bookingId",nullable = false)
    private Booking booking;
}
