package org.example.naverpay.member.service;

import org.example.naverpay.member.dao.PaymentDAO;
import org.example.naverpay.member.dto.PaymentDTO;
import org.example.naverpay.member.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements iPaymentService{

    private PaymentDAO paymentDAO;

    @Autowired
    public PaymentService(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }


    @Override
    public PaymentDTO getPaymentInfo(String sId) {

        Payment payment = paymentDAO.select(sId);
        return payment.toDTO();
    }

    @Override
    public boolean isPaymentInfoRemoved(String sId) {
        if (sId == null) {
            return false;
        }

        Payment payment = paymentDAO.select(sId);
        if (payment == null) {
            return false;
        }

        int res = paymentDAO.delete(sId);
        return res > 0;
    }
}
