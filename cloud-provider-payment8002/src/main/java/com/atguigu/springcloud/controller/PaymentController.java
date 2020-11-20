package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/add")
    public CommonResult Add(@RequestBody  Payment payment){

        int result=paymentService.Add(payment);

        log.info("添加数据"+payment);

        if(result>0){
            return new CommonResult(200,"添加数据成功！ serverPort="+serverPort,result);
        }else{
            return new CommonResult(444,"添加数据失败！",null );
        }

    }
    @GetMapping(value = "/get/{id}")
    public CommonResult GetPaymentById(@PathVariable("id") Long id){

        Payment payment=paymentService.GetPaymentById(id);

        log.info("查询数据热部署测试"+id);

        if(payment!=null){
            return new CommonResult(200,"查询数据成功！ serverPort="+serverPort,payment);
        }else{
            return new CommonResult(444,"查询数据失败！",null );
        }
    }
}
