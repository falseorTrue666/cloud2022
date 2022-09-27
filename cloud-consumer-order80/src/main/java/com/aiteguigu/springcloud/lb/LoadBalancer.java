package com.aiteguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @program: cloud2022
 * @ClassName LoadBalancer
 * @description:
 * @author: rrp
 * @create: 2022-09-22 15:04
 * @Version 1.0
 **/
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
