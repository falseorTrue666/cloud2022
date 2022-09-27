package com.aiteguigu.springcloud.controller;

import com.aiteguigu.springcloud.entities.CommonResult;
import com.aiteguigu.springcloud.entities.Payment;
import com.aiteguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @program: cloud2022
 * @ClassName OrderController
 * @description:
 * @author: rrp
 * @create: 2022-09-19 16:00
 * @Version 1.0
 **/
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 保存
     *
     * @param payment
     * @return
     */
    @GetMapping("/consumer/payment/save")
    public CommonResult save(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payment, CommonResult.class);
    }

    /**
     * 获取db数据
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/list/{id}")
    public CommonResult<Payment> list(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/list/" + id, CommonResult.class);
    }

    /**
     * 获取db数据
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/listForEntity/{id}")
    public CommonResult<Payment> list2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/list/" + id, CommonResult.class);
        System.out.println(forEntity.getBody());

        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    /**
     * 自定义负载均衡
     *
     * @return
     */
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLb() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (serviceInstances == null || serviceInstances.size() < 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(serviceInstances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}
