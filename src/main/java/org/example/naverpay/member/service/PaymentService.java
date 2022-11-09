package org.example.naverpay.member.service;

import org.example.naverpay.member.dao.PaymentDAO;
import org.example.naverpay.member.dao.ShoppingDAO;
import org.example.naverpay.member.dto.PaymentDTO;
import org.example.naverpay.member.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements iPaymentService{

    private PaymentDAO paymentDAO = PaymentDAO.getInstance();

    public static PaymentService paymentService = null;

    public static PaymentService getInstance(){
        if(paymentService == null){
            paymentService = new PaymentService();
        }
        return paymentService;
    }

    @Override
    public PaymentDTO getPaymentInfo(String sId) {

        Payment payment = paymentDAO.select(sId);
        PaymentDTO paymentDTO = payment.toDTO();
        return paymentDTO;
    }
}
