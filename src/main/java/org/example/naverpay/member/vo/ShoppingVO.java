package org.example.naverpay.member.vo;

import java.util.Objects;

public class ShoppingVO {

    private String mId = ""; // 멤버 아이디

    private String sId = ""; // 구매내역 아이디

    private String sTitle = ""; // 구매내역 제목

    private int sCount = 0; // 구매 수량

    private int sPayment = 0; // 구매 금액

    private String sDate = ""; // 구매 날짜  YYYY.MM.DD

    private String sStatus = ""; // 구매 상태 (결제 완료, 취소 완료 ...)

    private String seller = ""; // 판매자 이름

    private String sellerPhoneNumber = ""; // 판매자 전화번호

    ShoppingVO(){

    }

    public ShoppingVO(String mId, String sId, String sTitle, int sCount, int sPayment, String sDate, String sStatus, String seller, String sellerPhoneNumber) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingVO that = (ShoppingVO) o;
        return sCount == that.sCount && sPayment == that.sPayment && Objects.equals(mId, that.mId) && Objects.equals(sId, that.sId) && Objects.equals(sTitle, that.sTitle) && Objects.equals(sDate, that.sDate) && Objects.equals(sStatus, that.sStatus) && Objects.equals(seller, that.seller) && Objects.equals(sellerPhoneNumber, that.sellerPhoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, sId, sTitle, sCount, sPayment, sDate, sStatus, seller, sellerPhoneNumber);
    }

    @Override
    public String toString() {
        return "ShoppingVO{" +
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
