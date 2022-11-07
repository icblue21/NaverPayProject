package org.example.naverpay.member.dto;

import org.example.naverpay.member.entity.Shopping;
import org.example.naverpay.member.vo.ShoppingVO;

public class ShoppingDTO {

    private String mId = ""; // 멤버 아이디

    private String sId = ""; // 구매내역 아이디

    private String sTitle = ""; // 구매내역 제목

    private int sCount = 0; // 구매 수량

    private int sPayment = 0; // 구매 금액

    private String sDate = ""; // 구매 날짜  YYYY.MM.DD

    private String sStatus = ""; // 구매 상태 (결제 완료, 취소 완료 ...)

    private String seller = ""; // 판매자 이름

    private String sellerPhoneNumber = ""; // 판매자 전화번호

    ShoppingDTO(){

    }
    public ShoppingDTO(String mId, String sId, String sTitle, int sCount, int sPayment, String sDate, String sStatus, String seller, String sellerPhoneNumber) {
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

    public Shopping toEntity(){
        return new Shopping(mId,sId,sTitle,sCount,sPayment,sDate,sStatus,seller,sellerPhoneNumber);
    }
    public ShoppingVO toVO(){
        return new ShoppingVO(mId,sId,sTitle,sCount,sPayment,sDate,sStatus,seller,sellerPhoneNumber);
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsTitle() {
        return sTitle;
    }

    public void setsTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    public int getsCount() {
        return sCount;
    }

    public void setsCount(int sCount) {
        this.sCount = sCount;
    }

    public int getsPayment() {
        return sPayment;
    }

    public void setsPayment(int sPayment) {
        this.sPayment = sPayment;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String getsStatus() {
        return sStatus;
    }

    public void setsStatus(String sStatus) {
        this.sStatus = sStatus;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getSellerPhoneNumber() {
        return sellerPhoneNumber;
    }

    public void setSellerPhoneNumber(String sellerPhoneNumber) {
        this.sellerPhoneNumber = sellerPhoneNumber;
    }

    @Override
    public String toString() {
        return "ShoppingDTO{" +
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

    public String show(){
        return "제목 = "+sTitle+", 가격 = "+sPayment+", 구매날짜 = "+sDate+
                ", 구매상태 = "+sStatus+", 판매자 = "+seller+", 판매자 전화번호 = "+sellerPhoneNumber;
    }
}
