<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/21
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新部门</title>
    <style>
        form{
            text-align: center;
        }
    </style>
</head>
<body>
    <%@include file="header.jsp"%>
    <form action="<%=application.getContextPath()%>/dept?op=changeDept" method="post">
        <input type="text" name="deptNo" placeholder="请输入部门编号"><br>
        <input type="text" name="deptName" placeholder="请输入部门名称"><br>
        <input type="text" name="loc" placeholder="请输入部门地点"><br>
        <input type="submit" value="更新部门">
    </form>
</body>
</html>
