<%@ page import="com.tjetc.dao.EmpDao" %>
<%@ page import="com.tjetc.dao.impl.EmpDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tjetc.domain.Emp" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/23
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        EmpDao empDao = new EmpDaoImpl();
        List<Emp> emps = empDao.selectAll();
        Map<String,Emp> map = new HashMap<>();
        for (Emp emp : emps) {
            map.put(emp.getEname(),emp);
        }
        request.setAttribute("map",map);
    %>
</head>
<body>
${requestScope.Emp.ename}<br>
${requestScope.Emp.job}<br>
${requestScope.Emp.getDept()}<br>
</body>
</html>
