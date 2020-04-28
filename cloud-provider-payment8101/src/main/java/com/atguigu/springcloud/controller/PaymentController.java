package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年04月28日
 */
@RestController
@RequestMapping("/Payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("add")
    public CommonResult add(@RequestBody Payment payment){
        Integer result = paymentService.add(payment);
        log.info("插入一条支付信息后生成的自增id为：" + result);
        if (result > 0) {
           return new CommonResult(200,"生成支付信息成功了(*￣︶￣)",result);
        }
        return new CommonResult(444,"完蛋，生成支付信息失败了(⊙︿⊙)");
    }

    @GetMapping("getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询支付信息为：" + payment);
        if (payment != null) {
            return new CommonResult(200,"查询支付信息成功了(*￣︶￣)",payment);
        }
        return new CommonResult(404,"完蛋，查询支付信息失败了(⊙︿⊙)");
    }

}
