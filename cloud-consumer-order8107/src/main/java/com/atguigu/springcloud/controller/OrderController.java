package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年05月01日
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("paymentInfo")
    public String paymentInfo(){
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/consul",String.class);
        return result;
    }

}
