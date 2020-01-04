package com.zfx.cloud.config;

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
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
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