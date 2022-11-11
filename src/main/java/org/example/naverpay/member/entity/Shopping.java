package org.example.naverpay.member.entity;

import org.example.naverpay.member.dto.ShoppingDTO;

public class Shopping {

    private String mId = ""; // 멤버 아이디

    private String sId = ""; // 구매내역 아이디

    private String sTitle = ""; // 구매내역 제목

    private int sCount = 0; // 구매 수량

    private int sPayment = 0; // 구매 금액

    private String sDate = ""; // 구매 날짜  YYYY.MM.DD

    private String sStatus = ""; // 구매 상태 (결제 완료, 취소 완료 ...)

    private String seller = ""; // 판매자 이름

    private String sellerPhoneNumber = ""; // 판매자 전화번호

    Shopping(){

    }

    public Shopping(String mId, String sId, String sTitle, int sCount, int sPayment, String sDate, String sStatus, String seller, String sellerPhoneNumber) {
        this.mId = mId;
        this.sId = sId;
        this.sTitle = sTitle;
        this.sCount = sCount;
        this.sPayment = sPayment;
        this.sDate = sDate;
        this.sStatus = sStatus;
        this.seller = seller;
        this.sellerPhoneNumber = sellerPhoneNumber;
    }

    public ShoppingDTO toDTO(){ return new ShoppingDTO(mId,sId,sTitle,sCount,sPayment,sDate,sStatus,seller,sellerPhoneNumber);}
    public String getmId() {
        return mId;
    }

    public String getsId() {
        return sId;
    }

    public String getsTitle() {
        return sTitle;
    }

    public int getsCount() {
        return sCount;
    }

    public int getsPayment() {
        return sPayment;
    }

    public String getsDate() {
        return sDate;
    }

    public String getsStatus() {
        return sStatus;
    }

    public String getSeller() {
        return seller;
    }

    public String getSellerPhoneNumber() {
        return sellerPhoneNumber;
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "mId='" + mId + '\'' +
                ", sId='" + sId + '\'' +
                ", sTitle='" + sTitle + '\'' +
                ", sCount=" + sCount +
                ", sPayment=" + sPayment +
                ", sDate='" + sDate + '\'' +
                ", sStatus='" + sStatus + '\'' +
                ", seller='" + seller + '\'' +
                ", sellerPhoneNumber='" + sellerPhoneNumber + '\'' +
                '}';
    }
}
