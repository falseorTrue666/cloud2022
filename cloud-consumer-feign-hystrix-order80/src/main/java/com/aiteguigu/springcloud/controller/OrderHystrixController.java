package com.aiteguigu.springcloud.controller;

import com.aiteguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import javax.annotation.Resource;

/**
 * @program: cloud2022
 * @ClassName PaymentHystrixController
 * @description:
 * @author: rrp
 * @create: 2022-09-27 14:25
 * @Version 1.0
 **/
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
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
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallBackMethod",commandProperties =
//            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//            })
    @GetMapping("/payment/hystrix/timeout/{id}")
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Long id) {
        //int age = 1 / 0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("-=-=-=-=-=" + result);
        return result;
    }

    public String paymentTimeOutFallBackMethod(@PathVariable("id") Long id) {
        return "消费者80 自查 报错/服务者超时异常";
    }

    /**
     * 全局fallBack方法
     *
     * @return
     */
    public String payment_Global_FallbackMethod() {
        return "Global 全局报错";
    }
}
