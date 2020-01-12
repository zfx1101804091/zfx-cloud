package com.zfx.cloud.service.impl;

import com.zfx.cloud.dao.DeptDao;
import com.zfx.cloud.service.DeptService;
import com.zfx.cloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zheng-fx
 * @time: 2020/1/4 0004 13:40
 */
@Service
public class DeptServiceImpl implements DeptService {
    
    @Autowired
    private DeptDao deptDao;
    
    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptDao.findById(id);
    }

    /*add,get,list 符合controller层的restful风格*/
    @Override
    public List<Dept> list() {
        return deptDao.findAll();
    }
}
