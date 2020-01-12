package com.zfx.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.zfx.cloud"})
@ComponentScan("com.zfx.cloud")
public class ZfxCloudConsumerFeign_App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ZfxCloudConsumerFeign_App.class,args);
    }
}
