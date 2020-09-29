<%@ page import="com.tjetc.dao.EmpDao" %>
<%@ page import="com.tjetc.dao.impl.EmpDaoImpl" %>
<%@ page import="com.tjetc.domain.Emp" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/24
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%
        EmpDao dao = new EmpDaoImpl();
        Emp emp = dao.selectByIdAndName(7788,"SCOTT");
        session.setAttribute("emp",emp);
    %>
</head>
<body>
    <c:set var="isLogin" value="${emp.ename ne null}"/>
    <c:choose>
        <c:when test="${emp.dept.deptNo==10}">是10号部门</c:when>
        <c:when test="${emp.dept.deptNo==20}">是20号部门</c:when>
        <c:when test="${emp.dept.deptNo==30}">是30号部门</c:when>
        <c:when test="${emp.dept.deptNo==40}">是40号部门</c:when>
        <c:otherwise>不是10、20、30、40号部门</c:otherwise>
    </c:choose>
    <c:if test="${isLogin}">
        欢迎[${emp.ename}]访问此网站
    </c:if>
    <c:if test="${!isLogin}">
        对不起，
    </c:if>
</body>
</html>
