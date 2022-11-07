package org.example.naverpay.member.dto;

import org.example.naverpay.member.entity.Members;
import org.example.naverpay.member.vo.MembersVO;

public class MembersDTO {

    private String mId = ""; // 아이디

    private String mPw = ""; // 비밀번호

    private String mName = ""; // 이름

    private String mPoint = ""; // 적립 포인트

    private String mMoney = ""; // 충전 금액

    private String mCardCompany = "";

    private String mCardNumber = "";

    MembersDTO(){

    }

    public MembersDTO(String mId, String mPw) {
        this.mId = mId;
        this.mPw = mPw;
    }

    public MembersDTO(String mId, String mPw, String mName, String mPoint, String mMoney) {
        this.mId = mId;
        this.mPw = mPw;
        this.mName = mName;
        this.mPoint = mPoint;
        this.mMoney = mMoney;
    }

    public MembersDTO(String mId, String mPw, String mName, String mPoint, String mMoney, String mCardCompany, String mCardNumber) {
        this.mId = mId;
        this.mPw = mPw;
        this.mName = mName;
        this.mPoint = mPoint;
        this.mMoney = mMoney;
        this.mCardCompany = mCardCompany;
        this.mCardNumber = mCardNumber;
    }

    public Members toEntity() {
        return new Members(mId,mPw,mName,mPoint,mMoney,mCardCompany,mCardNumber);
    }

    public MembersVO toVO() {
        return new MembersVO(mId,mPw,mName,mPoint,mMoney,mCardCompany,mCardNumber);
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmPw() {
        return mPw;
    }

    public void setmPw(String mPw) {
        this.mPw = mPw;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPoint() {
        return mPoint;
    }

    public void setmPoint(String mPoint) {
        this.mPoint = mPoint;
    }

    public String getmMoney() {
        return mMoney;
    }

    public void setmMoney(String mMoney) {
        this.mMoney = mMoney;
    }

    public String getmCardCompany() {
        return mCardCompany;
    }

    public void setmCardCompany(String mCardCompany) {
        this.mCardCompany = mCardCompany;
    }

    public String getmCardNumber() {
        return mCardNumber;
    }

    public void setmCardNumber(String mCardNumber) {
        this.mCardNumber = mCardNumber;
    }

    @Override
    public String toString() {
        return "MembersDTO{" +
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
