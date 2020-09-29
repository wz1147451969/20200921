package com.tjetc.service.impl;

import com.tjetc.dao.DeptDao;
import com.tjetc.dao.impl.DeptDaoImpl;
import com.tjetc.domain.Dept;
import com.tjetc.service.DeptService;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    private DeptDao deptDao;

    public DeptServiceImpl() {
        this.deptDao = new DeptDaoImpl();
    }

    @Override
    public String addDept(String id, String name, String loc) {
        try {
            int deptNo = Integer.valueOf(id);
            if (this.deptDao.selectById(deptNo)!=null) return "对不起，此编号已存在无法进行注册！";
            if (this.deptDao.selectByName(name)!=null) return "对不起，此部门已存在无法进行注册！";
            return this.deptDao.insert(new Dept(deptNo,name,loc))>0?"添加成功！":"添加失败！";
        }catch (Exception e){
            return "对不起，添加格式输入不正确！";
        }
    }

    @Override
    public String removeDept(String id) {
        try {
            int deptNo = Integer.valueOf(id);
            if (this.deptDao.selectById(deptNo)==null) return "对不起，此编号不存在无法进行删除！";
            return this.deptDao.delete(deptNo)>0?"删除成功！":"删除失败！";
        }catch (Exception e){
            return "对不起，删除格式输入不正确！";
        }
    }

    @Override
    public String changeDept(String id, String name, String loc) {
        try {
            int deptNo = Integer.valueOf(id);
            if (this.deptDao.selectById(deptNo)==null) return "对不起，此编号不存在无法进行更新！";
            return this.deptDao.update(new Dept(deptNo,name,loc))>0?"更新成功！":"更新失败！";
        }catch (Exception e){
            return "对不起，更新格式输入不正确！";
        }
    }

    @Override
    public List<Dept> findAll() {
        try {
            return this.deptDao.selectAll();
        }catch (Exception e){
           e.printStackTrace();
           return null;
        }
    }

    @Override
    public Dept findById(String id) {
        try {
            int deptNo = Integer.valueOf(id);
            return this.deptDao.selectById(deptNo);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Dept findByName(String name) {
        try {
            return this.deptDao.selectByName(name);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Dept> findByLikeName(String name) {
        try {
            return this.deptDao.selectByLikeName(name);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
