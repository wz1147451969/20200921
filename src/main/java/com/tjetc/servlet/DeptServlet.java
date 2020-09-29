package com.tjetc.servlet;

import com.tjetc.domain.Dept;
import com.tjetc.service.DeptService;
import com.tjetc.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "DeptServlet",urlPatterns = "/dept")
public class DeptServlet extends HttpServlet {
    private DeptService deptService;

    public DeptServlet() {
        this.deptService = new DeptServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if ("addDept".equals(op)){
            this.addDept(req,resp);
        }else if ("removeDept".equals(op)){
            this.removeDept(req,resp);
        }else if ("changeDept".equals(op)){
            this.changeDept(req,resp);
        }else if ("findAll".equals(op)){
            this.findAll(req,resp);
        }else if ("findById".equals(op)){
            this.findById(req,resp);
        }else if ("findByName".equals(op)){
            this.findByName(req,resp);
        }else if ("findByLikeName".equals(op)){
            this.findByLikeName(req,resp);
        }
    }

    private void addDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptno = req.getParameter("deptno");
        String dname = req.getParameter("dname");
        String loc = req.getParameter("loc");
        String addDept = deptService.addDept(deptno,dname,loc);
        req.setAttribute("addDept",addDept);
        req.getRequestDispatcher("message.jsp").forward(req,resp);
    }

    private void removeDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptno = req.getParameter("deptno");
        String removeDept = deptService.removeDept(deptno);
        req.setAttribute("removeDept",removeDept);
        req.getRequestDispatcher("removeDept.jsp").forward(req,resp);
    }

    private void changeDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptno = req.getParameter("deptno");
        String dname = req.getParameter("dname");
        String loc = req.getParameter("loc");
        String changeDept = deptService.changeDept(deptno,dname,loc);
        req.setAttribute("changeDept",changeDept);
        req.getRequestDispatcher("changeDept.jsp").forward(req,resp);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> findAll = this.deptService.findAll();
        req.setAttribute("findAll",findAll);
        req.getRequestDispatcher("findAll.jsp").forward(req,resp);
    }

    private void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptno = req.getParameter("deptno");
        Dept findById = deptService.findById(deptno);
        req.setAttribute("findById",findById);
        req.getRequestDispatcher("findById.jsp").forward(req,resp);
    }

    private void findByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dname = req.getParameter("dname");
        Dept findByName = deptService.findByName(dname);
        req.setAttribute("findByName",findByName);
        req.getRequestDispatcher("findByName.jsp").forward(req,resp);
    }

    private void findByLikeName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dname = req.getParameter("dname");
        List<Dept> findByLikeName = deptService.findByLikeName(dname);
        req.setAttribute("findByLikeName",findByLikeName);
        req.getRequestDispatcher("findByLikeName.jsp").forward(req,resp);
    }
}
