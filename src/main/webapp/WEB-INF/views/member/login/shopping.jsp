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
    <!--ShoppingDetailController 에서 주문 내역 삭제 후 경고창 띄우기-->
    <c:if test="${sessionScope.alert == true}">
        <script>
            alert("해당 내역이 고객님의 결제현황에서 삭제되었습니다.");
        </script>
        ${sessionScope.alert = false}
    </c:if>

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
            <a href="/naver/pay/detail/?sId=${shoppingListDTO.sId}"> "${shoppingListDTO.show()}" </a>
            <li> </li>
        </c:forEach>
    </div>
</main>

<footer class="main__nav__next">
    <jsp:include page="../../layout/footer.jsp"/>
</footer>
</body>
</html>
