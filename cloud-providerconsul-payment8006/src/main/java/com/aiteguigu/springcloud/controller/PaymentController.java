package com.aiteguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: cloud2022
 * @ClassName PaymentController
 * @description:
 * @author: rrp
 * @create: 2022-09-21 17:16
 * @Version 1.0
 **/
@RestController
@Slf4j
public class PaymentController {

    @Value("serverPort")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String paymentConsul() {
        return "spring cloud consul" + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
