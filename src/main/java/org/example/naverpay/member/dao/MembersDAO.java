package org.example.naverpay.member.dao;

import org.example.naverpay.member.database.JDBCMgr;
import org.example.naverpay.member.entity.Members;
import org.h2.command.Prepared;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class MembersDAO implements iMembersDAO{

    private Connection conn = null;

    private PreparedStatement stmt = null;

    private ResultSet rs = null;

    private static final String MEMBER_SEARCH = "select * from members where mId like ? or uEmail like ?";
    private static final String MEMBER_SELECT_ALL = "select * from members";
    private static final String MEMBER_SELECT = "select * from members where mId = ?";
    private static final String MEMBER_INSERT = "insert into members values(?, ?, ?)";
    private static final String MEMBER_PASSWORD_UPDATE = "update members set mPw = ? where mId = ?";
    private static final String MEMBER_DELETE = "delete members where mId = ?";
    private static final String MEMBER_DELETE_ALL = "delete members";

    @Override
    public Members select(String uId) {
        Members member = null;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_SELECT);
            stmt.setString(1, uId);

            rs = stmt.executeQuery();

            if (rs.next()) {
                String mId = rs.getString("mId");
                String mPw = rs.getString("mPw");
                String mName = rs.getString("mName");
                String mPoint = rs.getString("mPoint");
                String mMoney = rs.getString("mMoney");
                String mCardCompany = rs.getString("mCardCompany");
                String mCardNumber = rs.getString("mCardNumber");
                member = new Members(mId, mPw, mName, mPoint, mMoney, mCardCompany, mCardNumber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return member;
    }


}
