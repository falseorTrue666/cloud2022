package com.aiteguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: cloud2022
 * @ClassName ApplicationContextConfig
 * @description:
 * @author: rrp
 * @create: 2022-09-21 11:29
 * @Version 1.0
 **/
@Configuration
public class ApplicationContextConfig {

    @Resource
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
