package com.tjetc.dao.impl;

import com.tjetc.dao.DeptDao;
import com.tjetc.domain.Dept;
import com.tjetc.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    Dept dept = null;
    List<Dept> depts = new ArrayList<Dept>();
    public int insert(Dept dept) {
        //调用Dbutil获取连接对象
        Connection conn = DButil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DButil.getPstmt(conn, "insert into dept(deptno,dname,loc) values(?,?,?)",
                dept.getDeptNo(), dept.getDeptName(), dept.getLoc());
        //执行插入操作
        int i = DButil.update(pstmt);
        //关闭资源
        DButil.close(conn,pstmt,null);
        return i;
    }

    public int delete(int id) {
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"delete from dept where deptno=?",id);
        int i = DButil.update(pstmt);
        DButil.close(conn,pstmt,null);
        return i;
    }

    public int update(Dept dept) {
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"update dept set dname=?,loc=? where deptno=?", dept.getDeptName(), dept.getLoc(), dept.getDeptNo());
        int i = DButil.update(pstmt);
        DButil.close(conn,pstmt,null);
        return i;
    }

    public List<Dept> selectAll(){
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"select * from dept");
        ResultSet rs = DButil.query(pstmt);
        try{
            while (rs.next()){
                dept = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
                depts.add(dept);
            }
            return depts;
        }catch (Exception e){
            return depts;
        }finally {
            DButil.close(conn,pstmt,rs);
        }
    }

    public Dept selectById(int id){
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"select * from dept where deptno=?",id);
        ResultSet rs = DButil.query(pstmt);
        try{
            if (rs.next()){
                dept = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
            return dept;
        }catch (Exception e){
            return dept;
        }finally {
            DButil.close(conn,pstmt,rs);
        }
    }

    public Dept selectByName(String name){
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"select * from dept where dname=?",name);
        ResultSet rs = DButil.query(pstmt);
        try{
            if (rs.next()){
                dept = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
            return dept;
        }catch (Exception e){
            return dept;
        }finally {
            DButil.close(conn,pstmt,rs);
        }
    }

    public List<Dept> selectByLikeName(String name){
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"select * from dept where dname like ?","%"+name+"%");
        ResultSet rs = DButil.query(pstmt);
        try {
            while (rs.next()){
                dept = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
                depts.add(dept);
            }
            return depts;
        }catch (Exception e){
            return depts;
        }finally {
            DButil.close(conn,pstmt,rs);
        }
    }
}
