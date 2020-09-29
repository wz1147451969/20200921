package com.tjetc.servlet;

import com.tjetc.domain.Goods;
import com.tjetc.service.GoodsService;
import com.tjetc.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "goodsServlet",urlPatterns = "/goods")
@MultipartConfig
public class GoodsServlet extends HttpServlet {
    private GoodsService service;

    public GoodsServlet() {
        this.service = new GoodsServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if("add".equals(op)){
            this.add(req,resp);
        }else if("findAll".equals(op)){
            this.findAll(req,resp);
        }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Goods> all = this.service.findAll();
        req.setAttribute("all",all);
        req.getRequestDispatcher("showAllGoods.jsp").forward(req,resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("").forward(req,resp);
    }
}
