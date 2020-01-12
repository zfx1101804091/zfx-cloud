package com.zfx.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zfx.cloud.service.DeptService;
import com.zfx.cloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
    
    @Autowired
    private DiscoveryClient discoveryClient;
    
    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept){
       return deptService.add(dept);
    }
    
    /*
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.get(id);
    }
    */

    
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept =  this.deptService.get(id);
        if(null == dept)
        {
            throw new RuntimeException("该ID："+id+"没有没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id)
                .setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }
    
    @GetMapping("/dept/list")
    public List<Dept> list(){
        return deptService.list();
    }
    
    
    /*服务发现相关*/
    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){

        List<String> services = discoveryClient.getServices();
        System.out.println("发现的服务----"+services);

        List<ServiceInstance> instances = discoveryClient.getInstances("ZFX-CLOUD-PROVIDER-8001");

        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        
        return this.discoveryClient;
    }
}
