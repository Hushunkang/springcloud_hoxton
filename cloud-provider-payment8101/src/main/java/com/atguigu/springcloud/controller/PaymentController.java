package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年04月28日
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;//对于注册到Eureka中的微服务，可以通过服务发现来获得它的信息

    @PostMapping("add")
    public CommonResult<Integer> add(@RequestBody Payment payment){
        Integer result = paymentService.add(payment);
        log.info("插入一条支付信息后生成的自增id为：" + result);
        if (result > 0) {
           return new CommonResult<>(200,"register center with eureka,serverPort:" + serverPort + "生成支付信息成功了(*￣︶￣)",result);
        }
        return new CommonResult<>(444,"完蛋，生成支付信息失败了(⊙︿⊙)");
    }

    @GetMapping("getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询支付信息为：" + payment + "O(∩_∩)O哈哈~");
        if (payment != null) {
            return new CommonResult<>(200,"register center with eureka,serverPort:" + serverPort + "查询支付信息成功了(*￣︶￣)",payment);
        }
        return new CommonResult<>(404,"完蛋，查询支付信息失败了(⊙︿⊙)");
    }

    @GetMapping("discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("eureka服务端上面注册了的微服务：" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "下面的实例（微服务的提供者的实例，即集群中的节点）\t:" + instance.getHost() + "\t:" + instance.getPort() + "\t:" + instance.getUri());
        }
        return this.discoveryClient;
    }

}
