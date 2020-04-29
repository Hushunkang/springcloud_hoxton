package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年04月28日
 */
@SpringBootApplication
@EnableEurekaClient//表示本微服务（我）就是要被注册到注册中心的微服务（微服务的提供者），即eureka服务端
public class PaymentApplication8103 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8103.class,args);
    }

}
