package lk.easycarrental.spring.repo;

import lk.easycarrental.spring.entity.Booking;
import lk.easycarrental.spring.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface PaymentRepo extends JpaRepository<Payment,String> {

    @Query(value = "select i from Payment i where i.booking.customer.email=:email")
    ArrayList<Payment> findAllByBooking_Customer_Email(@Param("email") String email);
}
