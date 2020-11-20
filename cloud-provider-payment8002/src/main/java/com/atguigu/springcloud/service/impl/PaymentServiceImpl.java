package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao  paymentDao;

    public int Add(Payment payment){ return paymentDao.Add(payment); }

    public Payment GetPaymentById(@Param("id") Long id){
        return paymentDao.GetPaymentById(id);
    }
}
