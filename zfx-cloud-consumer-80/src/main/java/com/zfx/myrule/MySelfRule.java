package com.zfx.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 自定义Ribbon规则类
 * @author: zheng-fx
 * @time: 2020/1/5 0005 21:59
 */
@Configuration
public class MySelfRule {
    
    @Bean
    public IRule myRule(){
        return new RandomRule_zfx();//Ribbon默认时轮询，这里我自定义为随机
    }
}
