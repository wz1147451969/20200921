<%@ page import="com.tjetc.domain.Emp" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/23
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示所有员工信息</title>
    <script src="<%=application.getContextPath()%>/js/jquery-1.11.3.js"></script>
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
    <script>
        $(function () {
            $(".delClass").click(function (event) {
                event.preventDefault();
                if (confirm("是否确认删除")){
                    window.location.href=$(this).attr("href");
                }else {
                    alert("删除操作取消!");
                }
            });
        })
    </script>
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
    <c:forEach items="${empPage.data}" var="e">
    <tr>

    </tr>
    </c:forEach>
    <tr>
        <td colspan="9" style="">
            <a href="<%=application.getContextPath()%>/emp?op=findAll&pageNum=1">首页</a>
            <a href="<%=application.getContextPath()%>/emp?op=findAll&pageNum=${empPage.prev()}">上一页</a>
            当前页 ${emp}
        </td>
    </tr>
</table>
</body>
</html>
