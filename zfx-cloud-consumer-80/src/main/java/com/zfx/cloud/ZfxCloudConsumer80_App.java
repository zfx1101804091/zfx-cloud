package com.zfx.cloud;

import com.zfx.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候就去加载我们自定义的Ribbon配置类，从而使配置生效
@RibbonClient(name = "ZFX-CLOUD-PROVIDER-8001",configuration = MySelfRule.class)
public class ZfxCloudConsumer80_App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ZfxCloudConsumer80_App.class,args);
    }
}
