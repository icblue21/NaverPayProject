<%@ page import="org.example.naverpay.util.Status" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>LOGIN</title>
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
    <h1>LOGIN</h1>
    <div>
        <form method="post" action="/login">
            <div class="form__list">
                <label for="mId">ID: </label>
                <input type="text" id="mId" name="mId" placeholder="INPUT YOUR ID" required/>
            </div>

            <div class="form__list">
                <label for="mPw">PASSWORD: </label>
                <input type="password" id="mPw" name="mPw" placeholder="INPUT YOUR PASSWORD" required/>
            </div>

            <div class="checkbox__form">
                <label for="save">AUTO LOGIN: </label>
                <input id="save" type="checkbox" name="save"/>
            </div>
            <input type="submit" name="submit" value="Submit">
        </form>
    </div>
</main>

</body>
</html>
