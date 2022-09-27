package com.aiteguigu.springcloud.service;

import com.aiteguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @program: cloud2022
 * @ClassName PaymentService
 * @description:
 * @author: rrp
 * @create: 2022-09-19 15:00
 * @Version 1.0
 **/
public interface PaymentService {

    /**
     * 保存
     * @param payment
     * @return
     */
    public int save(Payment payment);

    /**
     * 获取
     * @param id
     * @return
     */
    public Payment getPaymentList(@Param("id") Long id);
}
