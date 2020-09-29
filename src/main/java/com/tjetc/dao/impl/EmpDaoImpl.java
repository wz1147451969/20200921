package com.tjetc.dao.impl;

import com.tjetc.dao.EmpDao;
import com.tjetc.domain.Dept;
import com.tjetc.domain.Emp;
import com.tjetc.util.DButil;
import com.tjetc.util.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    @Override
    public int insert(Emp emp) {
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?,?)",emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDept().getDeptNo());
        int i = DButil.update(pstmt);
        DButil.close(conn,pstmt,null);
        return i;
    }

    @Override
    public int delete(int id) {
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"delete from emp where empno=?",id);
        int i = DButil.update(pstmt);
        DButil.close(conn,pstmt,null);
        return i;
    }

    @Override
    public int update(Emp emp) {
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?",emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDept().getDeptNo(),emp.getEmpno());
        int i = DButil.update(pstmt);
        DButil.close(conn,pstmt,null);
        return i;
    }

    @Override
    public List<Emp> selectAll() {
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"select * from emp e,dept d where e.deptno = d.deptno");
        ResultSet rs = DButil.query(pstmt);
        List<Emp> list = new ArrayList<Emp>();
        try {
            while (rs.next()){
                list.add(new Emp(rs.getInt("empno"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        rs.getInt("mgr"),
                        rs.getDate("hiredate"),
                        rs.getDouble("sal"),
                        this.format(rs.getObject("comm")),
                        new Dept(rs.getInt("deptno"),
                                rs.getString("dname"),
                                rs.getString("loc"))));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    private Double format(Object o){
        if (o!=null){
            return Double.valueOf(o.toString());
        }else {
            return null;
        }
    }
    @Override
    public Emp selectByIdAndName(int empno, String ename) {
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"select * from emp e,dept d where empno=? and ename=? and e.deptno = d.deptno",empno,ename);
        ResultSet rs = DButil.query(pstmt);
        try {
            if (rs.next()){
                return new Emp(rs.getInt("empno"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        rs.getInt("mgr"),
                        rs.getDate("hiredate"),
                        rs.getDouble("sal"),
                        this.format(rs.getObject("comm")),
                        new Dept(rs.getInt("deptno"),
                                rs.getString("dname"),
                                rs.getString("loc")));
            }
            return null;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Emp> selectManager() {
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"select * from emp e,dept d where empno in(select distinct mgr from emp where mgr is not null) and e.deptno= d.deptno");
        ResultSet rs = DButil.query(pstmt);
        List<Emp> list = new ArrayList<Emp>();
        try {
            while (rs.next()){
                list.add(new Emp(rs.getInt("empno"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        rs.getInt("mgr"),
                        rs.getDate("hiredate"),
                        rs.getDouble("sal"),
                        this.format(rs.getObject("comm")),
                        new Dept(rs.getInt("deptno"),
                                rs.getString("dname"),
                                rs.getString("loc"))));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Emp selectById(int id) {
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"select * from emp e,dept d where empno=? and e.deptno= d.deptno");
        ResultSet rs = DButil.query(pstmt);
        try {
            if (rs.next()){
                return new Emp(rs.getInt("empno"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        rs.getInt("mgr"),
                        rs.getDate("hiredate"),
                        rs.getDouble("sal"),
                        this.format(rs.getObject("comm")),
                        new Dept(rs.getInt("deptno"),
                                rs.getString("dname"),
                                rs.getString("loc")));
            }
            return null;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    private int count(){
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"select count(1) from emp");
        ResultSet rs = DButil.query(pstmt);
        try {
            if (rs.next()){
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    @Override
    public Page<Emp> selectByPage(int pageNum, int pageSize) {
        Page<Emp> page =new Page<>(pageNum,pageSize);
        page.setTotalData(this.count());
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"select * from emp e,dept d where e.deptno = d.deptno limit ?,?",page.start(),page.getPageSize());
        ResultSet rs = DButil.query(pstmt);
        List<Emp> list = new ArrayList<Emp>();
        try {
            while (rs.next()){
                list.add(new Emp(rs.getInt("empno"),
                        rs.getString("ename"),
                        rs.getString("job"),
                        rs.getInt("mgr"),
                        rs.getDate("hiredate"),
                        rs.getDouble("sal"),
                        this.format(rs.getObject("comm")),
                        new Dept(rs.getInt("deptno"),
                                rs.getString("dname"),
                                rs.getString("loc"))));
            }
            page.setData(list);
            return page;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
