package org.example.naverpay.member.dao;

import org.example.naverpay.member.database.JDBCMgr;
import org.example.naverpay.member.entity.Members;
import org.example.naverpay.member.entity.Payment;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PaymentDAO implements iPaymentDAO{

    private Connection conn = null;

    private PreparedStatement stmt = null;

    private ResultSet rs = null;

    private static final String PAYMENT_SELECT = "select * from payment where sId = ?";
    private static final String PAYMENT_DELETE = "delete payment where sId = ?";

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

    @Override
    public int delete(String shoppingId) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PAYMENT_DELETE);
            stmt.setString(1, shoppingId);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }
}
