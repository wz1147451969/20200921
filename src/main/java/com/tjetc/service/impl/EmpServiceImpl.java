package com.tjetc.service.impl;

import com.tjetc.dao.EmpDao;
import com.tjetc.dao.impl.EmpDaoImpl;
import com.tjetc.domain.Emp;
import com.tjetc.service.EmpService;
import com.tjetc.util.Page;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao;

    public EmpServiceImpl() {
        this.empDao = new EmpDaoImpl();
    }

    @Override
    public String addEmp(Emp emp) {
        if (this.empDao.selectByIdAndName(emp.getEmpno(),emp.getEname())!=null){
            return "对不起，该员工已经录入";
        }
        return this.empDao.insert(emp)>0?"录入信息成功！":"录入信息失败！";
    }

    @Override
    public List<Emp> findAll() {
        return this.empDao.selectAll();
    }

    @Override
    public List<Emp> findAllManager() {
        return this.empDao.selectManager();
    }

    @Override
    public Emp findById(String id) {
        return this.empDao.selectById(Integer.valueOf(id));
    }

    @Override
    public String changeEmp(Emp emp) {
        return this.empDao.update(emp)>0?"员工信息更新完毕":"员工信息更新失败";
    }

    @Override
    public String removeEmp(int id) {
        return this.empDao.delete(id)>0?"员工信息删除完毕":"员工信息删除失败";
    }

    @Override
    public Page<Emp> findByPage(int pageNum, int pageSize) {
        return this.empDao.selectByPage(pageNum,pageSize);
    }
}
