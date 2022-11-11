package org.example.naverpay.member.service;

import org.example.naverpay.member.dto.PaymentDTO;

public interface iPaymentService {

    PaymentDTO getPaymentInfo(String sId);
    boolean isPaymentInfoRemoved(String sId);
}