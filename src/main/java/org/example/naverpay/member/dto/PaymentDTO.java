package org.example.naverpay.member.dto;

import org.example.naverpay.member.entity.Payment;
import org.example.naverpay.member.vo.PaymentVO;

public class PaymentDTO{

    private String pId = ""; // 결제 정보 아이디

    private String sId = ""; // 구매 내역 아이디

    private String pMethod = ""; // 결제 수단 (카드 간편 결제 ... )

    private String detailPayMethod = "";

    private String pInfo = ""; // 결제 수단 정보 ( 일시불, 할부... )

    private String pDate = ""; // 결제 날짜 // YYYY.MM.DD HH:MM:SS

    private int paymentByMethod = 0; // 결제 수단에 의한 결제 금액

    private int paymentByPoint = 0; // 포인트 사용에 의한 결제 금액

    private int totalPayment = 0; // 총 결제 금액 ( 결제수단 + 포인트 )

    PaymentDTO(){

    }

    public PaymentDTO(String pId, String sId, String pMethod, String detailPayMethod, String pDate, int paymentByMethod, int totalPayment) {
        this.pId = pId;
        this.sId = sId;
        this.pMethod = pMethod;
        this.detailPayMethod = detailPayMethod;
        this.pDate = pDate;
        this.paymentByMethod = paymentByMethod;
        this.totalPayment = totalPayment;
    }

    public PaymentDTO(String pId, String sId, String pMethod, String detailPayMethod, String pInfo, String pDate, int paymentByMethod, int paymentByPoint, int totalPayment) {
        this.pId = pId;
        this.sId = sId;
        this.pMethod = pMethod;
        this.detailPayMethod = detailPayMethod;
        this.pInfo = pInfo;
        this.pDate = pDate;
        this.paymentByMethod = paymentByMethod;
        this.paymentByPoint = paymentByPoint;
        this.totalPayment = totalPayment;
    }

    public Payment toEntity(){
        return new Payment(pId,sId,pMethod,detailPayMethod,pInfo,pDate,paymentByMethod,paymentByPoint,totalPayment);
    }
    public PaymentVO toVO(){
        return new PaymentVO(pId,sId,pMethod,detailPayMethod,pInfo,pDate,paymentByMethod,paymentByPoint,totalPayment);
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getpMethod() {
        return pMethod;
    }

    public void setpMethod(String pMethod) {
        this.pMethod = pMethod;
    }

    public String getDetailPayMethod() {
        return detailPayMethod;
    }

    public void setDetailPayMethod(String detailPayMethod) {
        this.detailPayMethod = detailPayMethod;
    }

    public String getpInfo() {
        return pInfo;
    }

    public void setpInfo(String pInfo) {
        this.pInfo = pInfo;
    }

    public String getpDate() {
        return pDate;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    public int getPaymentByMethod() {
        return paymentByMethod;
    }

    public void setPaymentByMethod(int paymentByMethod) {
        this.paymentByMethod = paymentByMethod;
    }

    public int getPaymentByPoint() {
        return paymentByPoint;
    }

    public void setPaymentByPoint(int paymentByPoint) {
        this.paymentByPoint = paymentByPoint;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "pId='" + pId + '\'' +
                ", sId='" + sId + '\'' +
                ", pMethod='" + pMethod + '\'' +
                ", detailPayMethod='" + detailPayMethod + '\'' +
                ", pInfo='" + pInfo + '\'' +
                ", pDate='" + pDate + '\'' +
                ", paymentByMethod=" + paymentByMethod +
                ", paymentByPoint=" + paymentByPoint +
                ", totalPayment=" + totalPayment +
                '}';
    }
}
