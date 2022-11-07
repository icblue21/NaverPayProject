package org.example.naverpay.member.dao;

import org.example.naverpay.member.database.JDBCMgr;
import org.example.naverpay.member.entity.Members;
import org.example.naverpay.member.entity.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAO implements iPaymentDAO{

    private static PaymentDAO paymentDAO = null;

    private Connection conn = null;

    private PreparedStatement stmt = null;

    private ResultSet rs = null;

    private static final String PAYMENT_SELECT = "select * from payment where sId = ?";


    public static PaymentDAO getInstance() {
        if (paymentDAO == null) {
            paymentDAO = new PaymentDAO();
        }
        return paymentDAO;
    }


    @Override
    public Payment select(String shoppingId) {
        Payment payment = null;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PAYMENT_SELECT);
            stmt.setString(1, shoppingId);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String pId = rs.getString("pId");
                String sId = rs.getString("sId");
                String pMethod = rs.getString("pMethod");
                String pDetailPayMethod = rs.getString("pDetailPayMethod");
                String pInfo = rs.getString("pInfo");
                String pDate = rs.getString("pDate");
                int paymentByMethod = rs.getInt("paymentByMethod");
                int paymentByPoint = rs.getInt("paymentByPoint");
                int totalPayment = rs.getInt("totalPayment");
                payment = new Payment(pId, sId, pMethod, pDetailPayMethod,pInfo,pDate,paymentByMethod,paymentByPoint,totalPayment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return payment;
    }
}
