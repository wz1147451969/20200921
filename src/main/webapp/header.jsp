<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/21
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="margin: auto;text-align: center" >
    <a href="<%=application.getContextPath()%>/addDept.jsp">添加部门</a>
    <a href="<%=application.getContextPath()%>/dept?op=findById">根据编号查找部门</a>
    <a href="<%=application.getContextPath()%>/dept?op=findByName">根据名称查找部门</a>
    <a href="<%=application.getContextPath()%>/dept?op=findByLikeName">根据名称模糊查找部门</a>
    <a href="<%=application.getContextPath()%>/dept?op=findAll">显示所有部门</a>
    <a href="<%=application.getContextPath()%>/emp?op=addFind">添加员工信息</a>
    <a href="<%=application.getContextPath()%>/emp?op=findAll">显示所有员工信息</a>
    <c:if test="${empty sessionScope.admin}">
        <a href="<%=application.getContextPath()%>/login.jsp"><button>登录</button></a>
    </c:if>
</div>
