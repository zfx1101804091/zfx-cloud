package com.zfx.cloud.dao;

import com.zfx.cloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @description:
 * @author: zheng-fx
 * @time: 2020/1/4 0004 13:31
 */
@Mapper
public interface DeptDao {
    
    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
