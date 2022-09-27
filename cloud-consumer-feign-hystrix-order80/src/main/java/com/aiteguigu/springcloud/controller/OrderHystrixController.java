package com.aiteguigu.springcloud.controller;

import com.aiteguigu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: cloud2022
 * @ClassName PaymentHystrixController
 * @description:
 * @author: rrp
 * @create: 2022-09-27 14:25
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    /**
     * 正常访问，ok
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("-=-=-=-=-=" + result);
        return result;
    }

    /**
     * 超时访问，tineout
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Long id) {
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("-=-=-=-=-=" + result);
        return result;
    }
}
