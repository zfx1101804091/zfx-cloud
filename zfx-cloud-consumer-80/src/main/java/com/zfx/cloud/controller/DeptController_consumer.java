package com.zfx.cloud.controller;

import com.zfx.cloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    
    //通过微服务名字获得调用地址
    private static final String REST_URL_PREFIX = "http://ZFX-CLOUD-PROVIDER-8001";
    /*
    使用
    使用restTemplate访问restful接口非常的简单粗暴无脑。
    (url, requestMap, ResponseBean.class)这三个参数分别代表 
    REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */
    @Autowired
    private RestTemplate restTemplate;
    
    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return (List<Dept>) restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }
    
    //测试@EnableDiscoveryClient，消费端可以调用服务发现
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery",Object.class);
    }
}
