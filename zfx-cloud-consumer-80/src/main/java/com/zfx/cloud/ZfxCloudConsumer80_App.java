package com.zfx.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class ZfxCloudConsumer80_App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ZfxCloudConsumer80_App.class,args);
    }
}
