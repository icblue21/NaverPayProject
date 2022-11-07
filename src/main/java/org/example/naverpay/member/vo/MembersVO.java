package org.example.naverpay.member.vo;

import java.util.Objects;

public class MembersVO {
    
    private String mId = ""; // 아이디

    private String mPw = ""; // 비밀번호

    private String mName = ""; // 이름

    private String mPoint = ""; // 적립 포인트

    private String mMoney = ""; // 충전 금액

    private String mCardCompany = "";

    private String mCardNumber = "";

    public MembersVO(){

    }

    public MembersVO(String mId, String mPw, String mName, String mPoint, String mMoney) {
        this.mId = mId;
        this.mPw = mPw;
        this.mName = mName;
        this.mPoint = mPoint;
        this.mMoney = mMoney;
    }

    public MembersVO(String mId, String mPw, String mName, String mPoint, String mMoney, String mCardCompany, String mCardNumber) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MembersVO membersVO = (MembersVO) o;
        return Objects.equals(mId, membersVO.mId) && Objects.equals(mPw, membersVO.mPw) && Objects.equals(mName, membersVO.mName) && Objects.equals(mPoint, membersVO.mPoint) && Objects.equals(mMoney, membersVO.mMoney) && Objects.equals(mCardCompany, membersVO.mCardCompany) && Objects.equals(mCardNumber, membersVO.mCardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mPw, mName, mPoint, mMoney, mCardCompany, mCardNumber);
    }

    @Override
    public String toString() {
        return "MembersVO{" +
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
