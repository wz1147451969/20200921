<%@ page import="com.tjetc.domain.Emp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tjetc.util.DateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/23
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示所有员工信息</title>
    <%
        List<Emp> all = (List<Emp>) request.getAttribute("all");
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
        <th>职位</th>
        <th>领导编号</th>
        <th>入职日期</th>
        <th>薪资</th>
        <th>提成</th>
        <th>部门</th>
        <th>操作</th>
    </tr>
    <%
        for (Emp e: all) {
            String t= DateFormat.dateToString(e.getHiredate());
            String comm=e.getComm()!=null?e.getComm()+"":"无提成";
    %>
    <tr>
        <td><%=e.getEmpno()%></td>
        <td><%=e.getEname()%></td>
        <td><%=e.getJob()%></td>
        <td><%=e.getMgr()%></td>
        <td><%=t%></td>
        <td><%=e.getSal()%></td>
        <td><%=comm%></td>
        <td><%=e.getDept().getDeptNo()%></td>
        <td>
            <a href="<%=application.getContextPath()%>/emp?op=findById&empno=<%=e.getEmpno()%>"><button>编辑</button></a>
            <a href="<%=application.getContextPath()%>/emp?op=removeDept&deptno=<%=e.getEmpno()%>"><button>删除</button></a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
