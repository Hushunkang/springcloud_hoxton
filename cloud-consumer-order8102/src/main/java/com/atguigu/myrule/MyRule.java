package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年05月02日
 */
@Configuration
public class MyRule {//自定义ribbon本地负载均衡的负载均衡规则/算法

    @Bean
    public IRule myRule(){
        return new RandomRule();//随机规则/算法
    }

}
