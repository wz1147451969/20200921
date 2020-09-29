package com.tjetc.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tjetc.dao.EmpDao;
import com.tjetc.dao.impl.EmpDaoImpl;
import com.tjetc.domain.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(name = "JqueryServlet",urlPatterns = "/jquery")
public class JqueryServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("您进入了Get请求");
//        PrintWriter out = resp.getWriter();
//        out.write("你是真get");
//        out.flush();
        EmpDao dao = new EmpDaoImpl();
        List<Emp> emps = dao.selectAll();
        String s = JSON.toJSONString(emps, SerializerFeature.WriteNullNumberAsZero,SerializerFeature.PrettyFormat);
        PrintWriter out = resp.getWriter();
        out.write(s);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        System.out.println("接收的数据是："+account+"------"+password);
        PrintWriter out = resp.getWriter();
        out.write("ajax请求成功 你成功的post了");
        out.flush();
    }
}
