package com.springcloud.controller;




import com.springcloud.service.PaymentService;
import entities.CommonResult;
import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult creat(@RequestBody Payment payment){

        int result = paymentService.creat(payment);

        log.info("插入成功");
        return new CommonResult(200,"插入成功,serverPort:"+serverPort,result);
    }

    @GetMapping("/payment/get/{id}")
    public  CommonResult getId( @PathVariable("id") Long id){

        Payment payment = paymentService.getId(id);
        log.info("============123=========");
        return new CommonResult(200,"查询成功,serverPort:"+serverPort,payment);
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();

        for (String element:services){
            log.info("******element="+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance instance : instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

}
