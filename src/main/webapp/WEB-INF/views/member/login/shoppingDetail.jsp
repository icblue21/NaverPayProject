<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>SHOPPINGDETAIL</title>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<header><jsp:include page="../../layout/header.jsp"/></header>

<%@include file="../../message/showMessage.jsp"%>
<%
    showMessage(request, response, "logout", Status.SUCCESS);
    showMessage(request, response, "withdraw", Status.SUCCESS);
    showMessage(request, response, "signup", Status.SUCCESS); // 위치 수정
%>

<main>
    <h1>SHOPPING DETAIL</h1>
    <div>
        <h3> 결제 상세 정보</h3>
        <div>
            <h5> 결제 일자 : ${shoppingDTO.sDate} | 결제 번호 : ${paymentDTO.pId}</h5>
        </div>
        <div>
            <h5> 상품 정보 : ${shoppingDTO.sTitle},  상품 금액(수량) : ${shoppingDTO.sPayment}(${shoppingDTO.sCount}개)</h5>
            <h5> 판매자 : ${shoppingDTO.seller}, 판매자 전화번호 : ${shoppingDTO.sellerPhoneNumber}</h5>
            <h5> 진행상태 : ${shoppingDTO.sStatus}</h5>
        </div>
    </div>
    <div>
        <h3> 결제 금액 정보 </h3>
        <div>
            <h5> 결제 수단 : ${paymentDTO.pMethod} | 자세한 결제 수단 : ${paymentDTO.detailPayMethod} (${paymentDTO.pInfo})</h5>
            <h5> 결제 날짜 : ${paymentDTO.pDate}, 주문 금액 : ${paymentDTO.totalPayment}</h5>
            <h5> 결제 수단에 의한 금액 : ${paymentDTO.paymentByMethod}</h5>
            <h5> 포인트에 의한 금액 : ${paymentDTO.paymentByPoint}</h5>
        </div>
    </div>
    <div>
        <form method="post" action="/naver/pay/detail">
            <input type="hidden" name="sId" value="${shoppingDTO.sId}">
            <input type="submit" value="주문 내역 삭제">
        </form>
    </div>
</main>
</body>
</html>
