package com.zfx.cloud.controller;

import com.zfx.cloud.entities.Dept;
import com.zfx.cloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @description:
 *      消费者只管消费，不应该有service层
 * @author: zheng-fx
 * @time: 2020/1/4 0004 14:27
 */
@RestController
public class DeptController_consumer {
    
    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return this.deptClientService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list()
    {
        return this.deptClientService.list();
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object add(Dept dept)
    {
        return this.deptClientService.add(dept);
    }
}
