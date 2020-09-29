<%@ page import="java.util.List" %>
<%@ page import="com.tjetc.domain.Dept" %>
<%@ page import="com.tjetc.domain.Emp" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/24
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改员工信息界面</title>
    <%
        List<Dept> deptAll = (List<Dept>) request.getAttribute("deptAll");
        List<Emp> managerAll = (List<Emp>) request.getAttribute("managerAll");
        Emp emp = (Emp) request.getAttribute("emp");
    %>
</head>
<body>
<%@include file="header.jsp"%>
<form action="<%=application.getContextPath()%>/emp?op=updateEmp" method="post">
    <input>
</form>
</body>
</html>
