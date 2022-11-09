<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>HOME</title>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<header><jsp:include page="layout/header.jsp"/></header>

<%@include file="./message/showMessage.jsp"%>
<%
    showMessage(request, response, "logout", Status.SUCCESS);
    showMessage(request, response, "withdraw", Status.SUCCESS);
    showMessage(request, response, "signup", Status.SUCCESS); // 위치 수정
%>

<main>
    <h1>Naver Pay Home</h1>
    <h1>Hello ${uId}!</h1>

    <ul class="main__nav__next">
        <li>👉🏻<a href="/login"><b> Login 하기</b></a></li>
    </ul>
</main>
</body>
</html>
