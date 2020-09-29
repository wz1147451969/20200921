package com.tjetc.service;

import com.tjetc.domain.Dept;

import java.util.List;

public interface DeptService {
    String addDept(String id,String name,String loc);
    String removeDept(String id);
    String changeDept(String id,String name,String loc);
    List<Dept> findAll();
    Dept findById(String id);
    Dept findByName(String name);
    List<Dept> findByLikeName(String name);
}
