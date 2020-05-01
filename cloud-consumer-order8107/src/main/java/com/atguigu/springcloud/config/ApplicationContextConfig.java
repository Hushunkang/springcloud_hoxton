package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年04月28日
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced//负载均衡算法底层默认采用的是轮询算法
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
