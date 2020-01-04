package com.zfx.cloud.controller;

import com.zfx.cloud.entities.Dept;
import com.zfx.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 前后端分离的话，后台传给前台的都是json串 @RestController
 * @author: zheng-fx
 * @time: 2020/1/4 0004 13:45
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    
    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept){
       return deptService.add(dept);
    }
    
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.get(id);
    }
    
    @GetMapping("/dept/list")
    public List<Dept> list(){
        return deptService.list();
    }
}
