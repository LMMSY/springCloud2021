package com.springcloud.controller;

import com.springcloud.service.PaymentFeignService;
import entities.CommonResult;
import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getId(@PathVariable("id") Long id){

        return  paymentFeignService.getId(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){

       return  paymentFeignService.paymentFeignTimeout();
    }
}
