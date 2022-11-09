package org.example.naverpay.member.service;

import org.example.naverpay.member.dto.PaymentDTO;

import javax.servlet.http.HttpSession;

public interface iPaymentService {

    public boolean isLogin(HttpSession session);
    public boolean isPurchaseHistory(String sId);
    public PaymentDTO orderStatus(String sId);
}
