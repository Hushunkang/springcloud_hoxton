package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年04月30日
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "consul")
    public String paymentConsul() {
        return "register center with consul:" + serverPort + ":" +UUID.randomUUID().toString();
    }

}
