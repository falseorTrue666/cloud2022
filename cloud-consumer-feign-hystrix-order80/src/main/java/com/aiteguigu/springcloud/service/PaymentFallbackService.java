package com.aiteguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @program: cloud2022
 * @ClassName PaymentFallbackService
 * @description:
 * @author: rrp
 * @create: 2022-09-27 21:50
 * @Version 1.0
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    /**
     * ok
     *
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_OK(Long id) {
        return "PaymentFallbackService fall back  #paymentInfo_OK";
    }

    /**
     * 超时
     *
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_TimeOut(Long id) {
        return "PaymentFallbackService fall back #paymentInfo_TimeOut";
    }
}
