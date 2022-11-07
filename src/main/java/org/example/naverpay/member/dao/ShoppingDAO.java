package org.example.naverpay.member.dao;

import org.example.naverpay.member.database.JDBCMgr;
import org.example.naverpay.member.entity.Members;
import org.example.naverpay.member.entity.Shopping;
import org.example.naverpay.member.service.ShoppingService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ShoppingDAO implements iShoppingDAO{

    private static ShoppingDAO shoppingDAO = null;

    private Connection conn = null;

    private PreparedStatement stmt = null;

    private ResultSet rs = null;

    private static final String SHOPPING_SELECT = "select * from shopping where sId = ?";
    private static final String ALL_SHOPPING_LIST = "select * from shopping where mId = ? and sDate >= ? and sDate <= ?";
    private static final String SHOPPING_DELETE = "delete shopping where sId = ?";

    public static ShoppingDAO getInstance() {
        if (shoppingDAO == null) {
            shoppingDAO = new ShoppingDAO();
        }
        return shoppingDAO;
    }

    @Override
    public Shopping select(String shoppingId) {
        Shopping shopping = null;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SHOPPING_SELECT);
            stmt.setString(1, shoppingId);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String mId = rs.getString("mId");
                String sId = rs.getString("sId");
                String sTitle = rs.getString("sTitle");
                int sCount = rs.getInt("sCount");
                int sPayment = rs.getInt("sPayment");
                String sDate = rs.getString("sDate");
                String sStatus = rs.getString("sStatus");
                String seller = rs.getString("seller");
                String sellerPhoneNumber = rs.getString("sellerPhoneNumber");
                shopping = new Shopping(mId, sId, sTitle, sCount, sPayment, sDate, sStatus,seller,sellerPhoneNumber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return shopping;
    }

    @Override
    public List<Shopping> selectAll(String uId, String startDate, String endDate) {
        List<Shopping> memberList = new LinkedList<>();
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(ALL_SHOPPING_LIST);
            stmt.setString(1, uId);
            stmt.setString(2, startDate);
            stmt.setString(3, endDate);

            rs = stmt.executeQuery();
            while (rs.next()) {
                String mId = rs.getString("mId");
                String sId = rs.getString("sId");
                String sTitle = rs.getString("sTitle");
                int sCount = rs.getInt("sCount");
                int sPayment = rs.getInt("sPayment");
                String sDate = rs.getString("sDate");
                String sStatus = rs.getString("sStatus");
                String seller = rs.getString("seller");
                String sellerPhoneNumber = rs.getString("sellerPhoneNumber");

                memberList.add(new Shopping(mId, sId, sTitle, sCount, sPayment, sDate, sStatus,seller,sellerPhoneNumber));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return memberList;
    }

    @Override
    public int delete(String sId) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SHOPPING_DELETE);
            stmt.setString(1, sId);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }
}
