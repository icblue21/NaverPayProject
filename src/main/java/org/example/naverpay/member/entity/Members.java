package org.example.naverpay.member.entity;

import org.example.naverpay.member.vo.MembersVO;

import java.util.Objects;

public class Members {

    private String mId = ""; // 아이디

    private String mPw = ""; // 비밀번호

    private String mName = ""; // 이름

    private String mPoint = ""; // 적립 포인트

    private String mMoney = ""; // 충전 금액

    private String mCardCompany = "";

    private String mCardNumber = "";

    public Members(){

    }

    public Members(String mId, String mPw, String mName, String mPoint, String mMoney) {
        this.mId = mId;
        this.mPw = mPw;
        this.mName = mName;
        this.mPoint = mPoint;
        this.mMoney = mMoney;
    }

    public Members(String mId, String mPw, String mName, String mPoint, String mMoney, String mCardCompany, String mCardNumber) {
        this.mId = mId;
        this.mPw = mPw;
        this.mName = mName;
        this.mPoint = mPoint;
        this.mMoney = mMoney;
        this.mCardCompany = mCardCompany;
        this.mCardNumber = mCardNumber;
    }

    public String getmId() {
        return mId;
    }

    public String getmPw() {
        return mPw;
    }

    public String getmName() {
        return mName;
    }

    public String getmPoint() {
        return mPoint;
    }

    public String getmMoney() {
        return mMoney;
    }

    public String getmCardCompany() {
        return mCardCompany;
    }

    public String getmCardNumber() {
        return mCardNumber;
    }

    @Override
    public String toString() {
        return "Members{" +
                "mId='" + mId + '\'' +
                ", mPw='" + mPw + '\'' +
                ", mName='" + mName + '\'' +
                ", mPoint='" + mPoint + '\'' +
                ", mMoney='" + mMoney + '\'' +
                ", mCardCompany='" + mCardCompany + '\'' +
                ", mCardNumber='" + mCardNumber + '\'' +
                '}';
    }
}
