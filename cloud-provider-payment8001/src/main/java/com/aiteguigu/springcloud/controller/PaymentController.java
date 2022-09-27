package com.aiteguigu.springcloud.controller;

import com.aiteguigu.springcloud.entities.CommonResult;
import com.aiteguigu.springcloud.entities.Payment;
import com.aiteguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: cloud2022
 * @ClassName PaymentController
 * @description:
 * @author: rrp
 * @create: 2022-09-19 15:03
 * @Version 1.0
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 保存
     *
     * @param payment
     * @return
     */
    @PostMapping("/payment/save")
    public CommonResult save(@RequestBody Payment payment) {
        int save = paymentService.save(payment);
        log.info("****save success.");
        if (save > 0) {
            return new CommonResult(200, "保存成功,servicePort" + servicePort, save);
        } else {
            return new CommonResult(444, "保存失败,servicePort" + servicePort, null);
        }
    }

    /**
     * 获取
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/list/{id}")
    public CommonResult<Payment> list(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentList(id);
        log.info("****list success." + payment + "-=-=-=-=");
        if (payment != null) {
            return new CommonResult(200, "查询成功,servicePort" + servicePort, payment);
        } else {
            return new CommonResult(444, "查询失败,servicePort" + servicePort, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("----" + service + "----");
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : instances) {
            log.info("==" + serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        }
        return services;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLb() {
        return servicePort;
    }

    /**
     * 睡眠3秒中
     * @return
     */
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return servicePort;
    }
}
