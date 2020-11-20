package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static  final  String url="http://CLOUD-PAYMENT-SERVICE";
    //private static  final  String url="http://localhost:8001";
    @GetMapping(value = "/payment/add")
    public CommonResult<Payment> Add(Payment payment){
       return restTemplate.postForObject(url+"/payment/add",payment,CommonResult.class);
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult<Payment> GetPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(url+"/payment/get/"+id,CommonResult.class);
    }
}
