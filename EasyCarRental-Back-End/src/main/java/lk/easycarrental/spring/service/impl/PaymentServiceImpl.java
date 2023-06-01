package lk.easycarrental.spring.service.impl;

import lk.easycarrental.spring.dto.PaymentDTO;
import lk.easycarrental.spring.entity.Payment;
import lk.easycarrental.spring.repo.PaymentRepo;
import lk.easycarrental.spring.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    ModelMapper mapper;

    public void addPayment(PaymentDTO dto){
//        if (paymentRepo.existsByPaymentId(String.valueOf(dto.getPaymentId()))){
//            throw new RuntimeException("Payment "+dto.getPaymentId()+" Already Exist..!");
//        }
        Payment payment = mapper.map(dto,Payment.class);
        paymentRepo.save(payment);
    }

    public ArrayList<PaymentDTO> getAllPaymentsByCustomerEmail(String email){
        List<Payment> all = paymentRepo.findAllByBooking_Customer_Email(email);
        return mapper.map(all,new TypeToken<ArrayList<PaymentDTO>>(){}.getType());
    }
}
