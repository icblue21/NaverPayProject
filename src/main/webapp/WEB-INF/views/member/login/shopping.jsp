<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.example.naverpay.util.Status" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>SHOPPINGLIST</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <jsp:include page="../../layout/header.jsp"/>
</header>

<%@include file="../../message/showMessage.jsp"%>
<%
    showMessage(request, response, "login", Status.FAIL);
%>

<main>
    <h1>Shopping List</h1>
    <div>
        <form method="post" action="/naver/pay">
            <div class="form__list">
                <label for="startDate">START DATE </label>
                <input type="date" id="startDate" name="startDate" value="${startDate}"/>
            </div>

            <div class="form__list">
                <label for="endDate">END DATE</label>
                <input type="date" id="endDate" name="endDate" value="${endDate}"/>
            </div>
            <input type="submit" name="submit" value="Submit">
        </form>
    </div>
    <div>
        <c:forEach var="shoppingListDTO" items="${shoppingList}">
            <a href="/naver/pay/detail?sId=${shoppingListDTO.sId}"> "${shoppingListDTO.show()}" </a>
            <li> </li>
        </c:forEach>
    </div>
</main>

<footer class="main__nav__next">
    <jsp:include page="../../layout/footer.jsp"/>
</footer>
</body>
</html>
