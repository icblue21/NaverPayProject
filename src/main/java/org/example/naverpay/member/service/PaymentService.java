package org.example.naverpay.member.service;

import org.example.naverpay.member.dao.PaymentDAO;
import org.example.naverpay.member.dao.ShoppingDAO;
import org.example.naverpay.member.dto.PaymentDTO;
import org.example.naverpay.member.entity.Payment;
import org.example.naverpay.member.entity.Shopping;
import org.example.naverpay.session.SessionMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class PaymentService implements iPaymentService{

    private SessionMgr sessionMgr;
    private ShoppingDAO shoppingDAO;
    private PaymentDAO paymentDAO;
    @Autowired
    public PaymentService(SessionMgr sessionMgr, ShoppingDAO shoppingDAO, PaymentDAO paymentDAO) {
        this.sessionMgr = sessionMgr;
        this.shoppingDAO = shoppingDAO;
        this.paymentDAO = paymentDAO;
    }

    @Override
    public boolean isLogin(HttpSession session) {  //로그인 여부 판단
        if (session.getAttribute("SESSION_ID") == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isPurchaseHistory(String sId) { //구매내역이 있는지 확인
        if(sId.equals("")){
            return false;
        }
        Shopping shopping = shoppingDAO.select(sId);
        if (shopping == null){
            return false;
        }
        return true;
    }

    @Override
    public PaymentDTO orderStatus(String sId) {
        Payment payment = paymentDAO.select(sId);
        return payment.toDTO();
    }
}
