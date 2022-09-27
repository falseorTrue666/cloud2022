package com.aiteguigu.springcloud.service;

import com.aiteguigu.springcloud.entities.CommonResult;
import com.aiteguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: cloud2022
 * @ClassName PaymentFeignService
 * @description:
 * @author: rrp
 * @create: 2022-09-23 14:43
 * @Version 1.0
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/list/{id}")
    public CommonResult<Payment> list(@PathVariable("id") Long id);

    /**
     *
     * @return
     */
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
