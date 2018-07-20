<%--
  Created by IntelliJ IDEA.
  User: Kyrie
  Date: 2018/7/19
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
%>

<div class="row">
    <nav class="navbar navbar-inverse">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<%=contextPath%>/">wip的专栏</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav" id="nv1">
                    <li class="active" id="firstPage"><a href="<%=contextPath%>/">首页</a></li>
                    <li id="webPage"><a href="<%=contextPath%>/column/JavaWeb专栏/webPage">JavaWeb专栏</a></li>
                    <li id="androidPage"><a href="<%=contextPath%>/column/Android专栏/androidPage">Android专栏</a>
                    </li>
                    <li id="rnPage"><a href="<%=contextPath%>/column/React Native专栏/rnPage">React Native专栏</a>
                    </li>
                    <li id="ubuntuPage"><a href="<%=contextPath%>/column/Ubuntu专栏/ubuntuPage">Ubuntu专栏</a>
                    </li>
                </ul>
                <form class="navbar-form navbar-right">
                    <div class="input-group">
                        <input id="keyword" type="text" class="form-control" placeholder="搜索">
                        <span class="input-group-btn">
                            <button class="btn btn-default" onclick="search()" type="button">Go!</button>
                        </span>
                    </div>
                </form>
            </div>
        </div>
    </nav>
</div>

<script>
    var href = location.href;
    var id = href.substring(href.lastIndexOf("/") + 1, href.length);
        if (id == "") {
        id = "firstPage";
    }
    var ids = ["firstPage","webPage","androidPage","rnPage","ubuntuPage"];
    for (var i = 0; i< ids.length; i++) {
        if (id == ids[i]) {
            $("#" + id).attr("class","active");
            if (id == "firstPage") {
                document.title = "首页";
            } else if(id == "webPage") {
                document.title = "JavaWeb专栏";
            } else if (id == "androidPage") {
                document.title = "Android专栏";
            } else if (id =="rnPage") {
                document.title = "React Native专栏";
            } else {
                document.title = "Ubuntu专栏";
            }
        } else {
            $("#" + ids[i]).removeAttr("class");
        }
    }

    function search() {
        var searchStr = $("#keyword").val();
        if (searchStr == "" || searchStr == null || searchStr == undefined) {
            alert("请输入要查找的字符串！");
            return false;
        }
        location.href = "/search?keyword="+searchStr;

    }

</script>