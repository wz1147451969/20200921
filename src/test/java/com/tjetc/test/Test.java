package com.tjetc.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tjetc.dao.DeptDao;
import com.tjetc.dao.EmpDao;
import com.tjetc.dao.impl.DeptDaoImpl;
import com.tjetc.dao.impl.EmpDaoImpl;
import com.tjetc.domain.Dept;
import com.tjetc.domain.Emp;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        //DeptDao deptDao=new DeptDaoImpl();
        //int i = deptDao.insert(new Dept(50,"销售部","天津"));
        //int i = deptDao.delete(50);
        //int i = deptDao.update(new Dept(50,"市场部","北京"));
//        List<Dept> depts = deptDao.selectAll();
//        for (Dept dept : depts) {
//            System.out.println(dept);
//        }
        //Dept dept = deptDao.selectById(50);
        //Dept dept = deptDao.selectByName("销售部");
//        List<Dept> depts = deptDao.selectByLikeName("销%");
//        for (Dept dept : depts) {
//            System.out.println(dept);
//        }
        //System.out.println(i);
        EmpDao dao = new EmpDaoImpl();
        List<Emp> emps = dao.selectAll();
        String s = JSON.toJSONString(emps, SerializerFeature.WriteNullNumberAsZero,SerializerFeature.PrettyFormat);
        System.out.println(s);
    }
}
