<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/25
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jquery的ajax的请求设计</title>
    <script>
        $(function () {
            $("#myForm").submit(function () {
                $.ajax({
                    url:$("#myForm").attr("action"),
                })
            })
        })
    </script>
</head>
<body>
    <form id="myForm" action="<%=application.getContextPath()%>/jquery" method="post">
        <input type="text" name="account" id="account" placeholder="请输入账号"><br>
        <input type="password" name="password" id="password" placeholder="请输入密码"><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
