<%@ page import="com.tjetc.domain.Dept" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/21
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示所有部门</title>
    <%
        List<Dept> findAll = (List<Dept>) request.getAttribute("findAll");
    %>
    <style>
        table{
            margin: auto;
            text-align: center;
            border-collapse: collapse;
        }
        table,th,td{
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <%@include file="header.jsp"%>
    <table>
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>地点</th>
            <th>操作</th>
        </tr>
        <%
            for (Dept dept: findAll) {
        %>
        <tr>
            <td><%=dept.getDeptNo()%></td>
            <td><%=dept.getDeptName()%></td>
            <td><%=dept.getLoc()%></td>
            <td>
                <a href="<%=application.getContextPath()%>/dept?op=changeDept&deptno=<%=dept.getDeptNo()%>"><button>编辑</button></a>
                <a href="<%=application.getContextPath()%>/dept?op=removeDept&deptno=<%=dept.getDeptNo()%>"><button>删除</button></a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
