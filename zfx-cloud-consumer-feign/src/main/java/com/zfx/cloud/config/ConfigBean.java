package com.zfx.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 *         类似spring里面的applicationContext.xml写入的注入Bean
 * @author: zheng-fx
 * @time: 2020/1/4 0004 14:18
 */
@Configuration
public class ConfigBean {
    
//  RestTemplate提供了多种便捷访问远程Http服务的方法， 
//  是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集
    @Bean
    @LoadBalanced//Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端       负载均衡的工具。
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    
    @Bean
    public IRule myRule(){
        //用我们重新选择的随机算法替代默认的轮询算法
//        return new RandomRule();
        //先按默认的轮询策略获取服务，如果失败则在指定时间进行重试，获取可用服务（即获取不到的服务，重试几次连不上就不去获取了）
        return new RetryRule();
    }
}


 /*
    @Bean
    public DeptService getDeptService{
       return new DeptService();
    }
    
    applicationContext.xml
    <bean id="deptService" class="com.zfx.cloud.service.impl.DeptServiceImpl">
 */