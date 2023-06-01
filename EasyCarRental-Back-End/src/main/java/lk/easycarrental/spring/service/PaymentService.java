package lk.easycarrental.spring.service;

import lk.easycarrental.spring.dto.PaymentDTO;

import java.util.ArrayList;

public interface PaymentService {
    public void addPayment(PaymentDTO dto);

    public ArrayList<PaymentDTO> getAllPaymentsByCustomerEmail(String email);
}
