package com.tjetc.dao;

import com.tjetc.domain.Emp;
import com.tjetc.util.Page;

import java.util.List;

public interface EmpDao {
    int insert(Emp emp);
    int delete(int id);
    int update(Emp emp);
    List<Emp> selectAll();
    Emp selectByIdAndName(int empno,String ename);
    List<Emp> selectManager();
    Emp selectById(int id);
    Page<Emp> selectByPage(int pageNum,int pageSize);
}
