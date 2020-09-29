package com.tjetc.servlet;

import com.tjetc.domain.Dept;
import com.tjetc.domain.Emp;
import com.tjetc.service.DeptService;
import com.tjetc.service.EmpService;
import com.tjetc.service.impl.DeptServiceImpl;
import com.tjetc.service.impl.EmpServiceImpl;
import com.tjetc.util.DateFormat;
import com.tjetc.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "EmpServlet",urlPatterns = "/emp")
public class EmpServlet extends HttpServlet {
    private DeptService deptService;
    private EmpService empService;
    public EmpServlet(){
        this.deptService = new DeptServiceImpl();
        this.empService = new EmpServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if ("addFind".equals(op)){
            this.addFind(req,resp);
        }else if ("addEmp".equals(op)){
            this.addEmp(req,resp);
        }else if ("findAll".equals(op)){
            this.findAll(req,resp);
        }else if ("findById".equals(op)){
            this.findById(req,resp);
        }else if ("updateEmp".equals(op)){
            this.updateEmp(req,resp);
        }else if ("remove".equals(op)){
            this.remove(req,resp);
        }
    }

    private void addFind(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> deptAll = this.deptService.findAll();
        List<Emp> managerAll = this.empService.findAllManager();
        req.setAttribute("deptAll",deptAll);
        req.setAttribute("managerAll",managerAll);
        req.getRequestDispatcher("addEmp.jsp").forward(req,resp);
        //req.getRequestDispatcher("Demo.jsp").forward(req,resp);
    }

    private void addEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empno = req.getParameter("empno");
        String ename = req.getParameter("ename");
        String job = req.getParameter("job");
        String mgr = req.getParameter("mgr");
        String hiredate = req.getParameter("hiredate");
        String sal = req.getParameter("sal");
        String comm = req.getParameter("comm");
        String deptno = req.getParameter("deptno");
        Dept d = new Dept();
        d.setDeptNo(Integer.valueOf(deptno));
        String info = this.empService.addEmp(new Emp(Integer.valueOf(empno),
                ename,
                job,
                Integer.valueOf(mgr),
                DateFormat.stringToDate(hiredate),
                Double.valueOf(sal),
                Double.valueOf(comm),
                d));
        req.setAttribute("info",info);
        req.getRequestDispatcher("message.jsp").forward(req,resp);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        Page<Emp> empPage = this.empService.findByPage(pageNum !=null?Integer.valueOf(pageNum):1,3);
        req.setAttribute("empPage",empPage);
        req.getRequestDispatcher("showAllEmp2.jsp").forward(req,resp);
    }

    private void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empno = req.getParameter("empno");
        Emp emp = this.empService.findById(empno);
        List<Dept> deptAll = this.deptService.findAll();
        List<Emp> managerAll = this.empService.findAllManager();
        req.setAttribute("deptAll",deptAll);
        req.setAttribute("managerAll",managerAll);
        req.setAttribute("emp",emp);
        req.getRequestDispatcher("updateEmp.jsp").forward(req,resp);
    }

    private void updateEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empno = req.getParameter("empno");
        String ename = req.getParameter("ename");
        String job = req.getParameter("job");
        String mgr = req.getParameter("mgr");
        String hiredate = req.getParameter("hiredate");
        String sal = req.getParameter("sal");
        String comm = req.getParameter("comm");
        String deptno = req.getParameter("deptno");
        Dept d = new Dept();
        d.setDeptNo(Integer.valueOf(deptno));
        String info = this.empService.addEmp(new Emp(Integer.valueOf(empno),
                ename,
                job,
                Integer.valueOf(mgr),
                DateFormat.stringToDate(hiredate),
                Double.valueOf(sal),
                Double.valueOf(comm),
                d));
        req.setAttribute("info",info);
        req.getRequestDispatcher("message.jsp").forward(req,resp);
    }

    private void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empno = req.getParameter("empno");
        String info = this.empService.removeEmp(Integer.valueOf(empno));
        resp.sendRedirect(this.getServletContext().getContextPath()+"/emp?op=findAll");
    }
}
