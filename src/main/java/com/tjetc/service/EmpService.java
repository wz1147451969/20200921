package com.tjetc.service;

import com.tjetc.domain.Emp;
import com.tjetc.util.Page;

import java.util.List;

public interface EmpService {
    String addEmp(Emp emp);
    List<Emp> findAll();
    List<Emp> findAllManager();
    Emp findById(String id);
    String changeEmp(Emp emp);
    String removeEmp(int id);
    Page<Emp> findByPage(int pageNum,int pageSize);
}
