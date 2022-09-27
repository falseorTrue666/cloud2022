package com.aiteguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: cloud2022
 * @ClassName ApplicationContextConfig
 * @description:
 * @author: rrp
 * @create: 2022-09-19 16:06
 * @Version 1.0
 **/
@Configuration
public class ApplicationContextConfig
{

    @Bean
//    @LoadBalanced
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }
}
