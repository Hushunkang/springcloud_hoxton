package com.atguigu.springcloud;

import com.atguigu.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年04月28日
 */
@SpringBootApplication
@EnableEurekaClient//表示本微服务（我）就是要被注册到注册中心的微服务（微服务的提供者），即eureka客户端
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)//表示负载均衡规则用我的规则，不要用出厂默认的规则（即轮询的规则）
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

}
