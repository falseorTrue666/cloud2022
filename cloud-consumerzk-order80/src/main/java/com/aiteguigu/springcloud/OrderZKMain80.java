package com.aiteguigu.springcloud;

import org.springframework.asm.SpringAsmInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: cloud2022
 * @ClassName OrderZKMain80
 * @description:
 * @author: rrp
 * @create: 2022-09-21 11:26
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain80.class, args);
    }
}
