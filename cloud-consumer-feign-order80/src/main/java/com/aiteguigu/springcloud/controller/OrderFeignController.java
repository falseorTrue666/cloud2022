package com.aiteguigu.springcloud.controller;

import com.aiteguigu.springcloud.entities.CommonResult;
import com.aiteguigu.springcloud.entities.Payment;
import com.aiteguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: cloud2022
 * @ClassName OrderFeignController
 * @description:
 * @author: rrp
 * @create: 2022-09-23 14:51
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    /**
     * 获取
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/list/{id}")
    public CommonResult<Payment> list(@PathVariable("id") Long id) {
        return paymentFeignService.list(id);
    }

    @GetMapping("/payment/feign/timeout/{id}")
    public String paymentFeignTimeout(@PathVariable("id") Long id){
        return paymentFeignService.paymentFeignTimeout();
    }
}
