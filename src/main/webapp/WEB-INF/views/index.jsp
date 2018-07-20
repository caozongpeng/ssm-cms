<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kyrie
  Date: 2018/7/19
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
%>
<html>
<head>
    <title>首页</title>
    <jsp:include page="comm/head.jsp"/>
    <link rel="stylesheet" href="<%=contextPath%>/static/mycss.css">
</head>
<body>
<jsp:include page="comm/top.jsp"/>

<c:forEach items="${articles}" var="article" begin="0" step="1">
    <div class="row">
        <div class="container">
            <div class="jumbotron">
                <h3>${article.title}</h3>
                <span class="summary">${article.summary}</span><br><br>
                <p><a class="btn btn-primary btn-lg" href="/detail/${article.id}/firstPage" role="button">阅读全文</a></p>
            </div>
        </div>
    </div>
</c:forEach>


</body>
</html>
