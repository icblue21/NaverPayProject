package org.example.naverpay.member.dao;

import org.example.naverpay.member.entity.Payment;

public interface iPaymentDAO {

    Payment select(String sId);
    int delete(String pId);
}
