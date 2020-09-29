package com.tjetc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "AjaxDemoServlet",urlPatterns = "/ajax")
public class AjaxDemoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("您使用的是post请求");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String info = req.getParameter("info");
        System.out.println("接受的info是"+info);
        System.out.println("name:"+name+"，password="+password);
        PrintWriter out = resp.getWriter();
        out.write("恭喜你使用了post请求");
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("您使用的是get请求");
        String info = req.getParameter("info");
        System.out.println("接受的info是"+info);
        PrintWriter out = resp.getWriter();
        out.write("你个损色儿~~~");
        out.flush();
    }
}
