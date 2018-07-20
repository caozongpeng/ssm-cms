<%--
  Created by IntelliJ IDEA.
  User: Kyrie
  Date: 2018/7/19
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详情</title>
    <jsp:include page="comm/head.jsp"/>
</head>
<body>
<jsp:include page="comm/top.jsp"/>
<div class="container">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">${article.title}</h3>
        </div>
        <div class="panel-body">

            <span>${article.content}</span>
        </div>
    </div>
</div>


</body>
</html>
