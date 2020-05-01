package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年05月01日
 */
@SpringBootApplication
@EnableDiscoveryClient//服务（微服务的提供者）发现，对于注册到注册中心中的微服务的提供者，可以通过服务发现来获得它的信息
//EnableDiscoveryClient注解用于向使用nacos、consul、zookeeper作为注册中心的时候，提供服务发现功能
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

}
