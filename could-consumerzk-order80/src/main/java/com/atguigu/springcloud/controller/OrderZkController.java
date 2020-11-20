package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZkController {
    @Resource
    private RestTemplate restTemplate;

    private static  final  String url="http://cloud-provider-payment";
    //private static  final  String url="http://localhost:8001";
    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo(Payment payment){
        return restTemplate.getForObject(url+"/payment/zk",String.class);
    }


}

