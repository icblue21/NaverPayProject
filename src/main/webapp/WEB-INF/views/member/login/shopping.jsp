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
        <form method="post" action="/members/shopping">
            <div class="form__list">
                <label for="startDate">START DATE </label>
                <input type="text" id="startDate" name="startDate" placeholder="yyyy.mm.dd" required/>
            </div>

            <div class="form__list">
                <label for="endDate">END DATE</label>
                <input type="text" id="endDate" name="endDate" placeholder="yyyy.mm.dd" required/>
            </div>
            <input type="submit" name="submit" value="Submit">
        </form>
    </div>
    <div>
        <c:forEach var="shoppingListDTO" items="${shoppingList}">
            <a href="/members/shoppingDetail?sId=${shoppingListDTO.sId}"> "${shoppingListDTO.show()}" </a>
            <li> </li>
        </c:forEach>
    </div>
</main>

<footer class="main__nav__next">
    <jsp:include page="../../layout/footer.jsp"/>
</footer>
</body>
</html>
