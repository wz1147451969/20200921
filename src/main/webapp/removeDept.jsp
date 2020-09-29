<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/21
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除部门</title>
    <style>
        form{
            text-align: center;
        }
    </style>
</head>
<body>
    <%@include file="header.jsp"%>
    <form action="<%=application.getContextPath()%>/dept?op=removeDept" method="post">
        <input type="text" name="deptNo" placeholder="请输入部门编号"><br>
        <input type="submit" value="删除部门">
    </form>
</body>
</html>
