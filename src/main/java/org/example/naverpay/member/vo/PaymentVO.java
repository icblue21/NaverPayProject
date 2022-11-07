package org.example.naverpay.member.vo;

import java.util.Objects;

public class PaymentVO {

    private String pId = ""; // 결제 정보 아이디

    private String sId = ""; // 구매 내역 아이디

    private String pMethod = ""; // 결제 수단 (카드 간편 결제 ... )

    private String detailPayMethod = ""; // 자세한 결제 수단 (ex. 신한 (카드번호) 일시불 )

    private String pInfo = ""; // 결제 수단 정보 ( 일시불, 할부... )

    private String pDate = ""; // 결제 날짜 // YYYY.MM.DD HH:MM:SS

    private int paymentByMethod = 0; // 결제 수단에 의한 결제 금액

    private int paymentByPoint = 0; // 포인트 사용에 의한 결제 금액

    private int totalPayment = 0; // 총 결제 금액 ( 결제수단 + 포인트 )

    public PaymentVO(){

    }

    public PaymentVO(String pId, String sId, String pMethod, String detailPayMethod, String pDate, int paymentByMethod, int totalPayment) {
        this.pId = pId;
        this.sId = sId;
        this.pMethod = pMethod;
        this.detailPayMethod = detailPayMethod;
        this.pDate = pDate;
        this.paymentByMethod = paymentByMethod;
        this.totalPayment = totalPayment;
    }

    public PaymentVO(String pId, String sId, String pMethod, String detailPayMethod, String pInfo, String pDate, int paymentByMethod, int paymentByPoint, int totalPayment) {
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

    public String getpId() {
        return pId;
    }

    public String getsId() {
        return sId;
    }

    public String getpMethod() {
        return pMethod;
    }

    public String getDetailPayMethod() {
        return detailPayMethod;
    }

    public String getpInfo() {
        return pInfo;
    }

    public String getpDate() {
        return pDate;
    }

    public int getPaymentByMethod() {
        return paymentByMethod;
    }

    public int getPaymentByPoint() {
        return paymentByPoint;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentVO paymentVO = (PaymentVO) o;
        return paymentByMethod == paymentVO.paymentByMethod && paymentByPoint == paymentVO.paymentByPoint && totalPayment == paymentVO.totalPayment && Objects.equals(pId, paymentVO.pId) && Objects.equals(sId, paymentVO.sId) && Objects.equals(pMethod, paymentVO.pMethod) && Objects.equals(detailPayMethod, paymentVO.detailPayMethod) && Objects.equals(pInfo, paymentVO.pInfo) && Objects.equals(pDate, paymentVO.pDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pId, sId, pMethod, detailPayMethod, pInfo, pDate, paymentByMethod, paymentByPoint, totalPayment);
    }

    @Override
    public String toString() {
        return "PaymentVO{" +
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
