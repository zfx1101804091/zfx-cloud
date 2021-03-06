package com.zfx.cloud.service;

import com.zfx.cloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @description:
 *  修改microservicecloud-api工程，
 *  根据已经有的DeptClientService接口新建一个实现了
 *  FallbackFactory接口的类DeptClientServiceFallbackFactory
 * @author: zheng-fx
 * @time: 2020/1/12 0012 15:25
 */

@FeignClient(value = "ZFX-CLOUD-PROVIDER-8001",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list();

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept);

}
