package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    
    public int Add(Payment payment);

    public Payment GetPaymentById(@Param("id") Long id);
}
