<%--
  Created by IntelliJ IDEA.
  User: Kyrie
  Date: 2018/7/20
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String contextPath = request.getContextPath();
%>
<html>
<head>
    <title>后台管理</title>
    <script src="<%=contextPath%>/static/jquery-3.1.1.js"></script>
    <script src="<%=contextPath%>/static/bootstrap/js/bootstrap.js"></script>
    <link href="<%=contextPath%>/static/bootstrap/css/bootstrap.css" rel="stylesheet"/>
    <link href="<%=contextPath%>/static/bootstrap/css/bootstrap-theme.css" rel="stylesheet"/>
</head>
<body>

<div class="container">
    <p>欢迎：${sessionScope.user.username}</p>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><h4>文章列表</h4></div>
        <div class="panel-body">
            <p><a class="btn btn-primary btn-sm" href="/admin/write" role="button">写博客</a></p>
        </div>

        <table class="table">
            <tr class="info">
                <td>编号</td>
                <td>标题</td>
                <td>摘要</td>
                <td style="text-align: center" colspan="2">操作</td>
            </tr>
            <c:forEach begin="0" var="article" items="${articles}" step="1">
                <tr>
                    <td>${article.id}</td>
                    <td>${article.title}</td>
                    <td>${article.summary}</td>
                    <td><a href="/admin/update/${article.id}">修改</a></td>
                    <td><a class="delete" href="" data-toggle="modal" onclick="deleteArticle(${article.id})">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="exampleModalLabel">提示信息</h4>
            </div>
            <div class="modal-body">
                确定要删除此文章吗？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="deleteById()">确认</button>
            </div>
        </div>
    </div>
</div>

<script>
    function deleteArticle(articleID) {
        $(".delete").attr("data-target","#deleteModal");
        $("#deleteModal").attr("articleID",articleID);
    }

    function deleteById() {
        var articleId = $("#deleteModal").attr("articleID");
        location.href = "/admin/delete/"+articleId;
    }
</script>


</body>
</html>
