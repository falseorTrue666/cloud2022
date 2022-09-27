package com.aiteguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: cloud2022
 * @ClassName MyLb
 * @description: 自定义负载均衡
 * @author: rrp
 * @create: 2022-09-22 15:07
 * @Version 1.0
 **/
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;

        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("-=-=-次数=-=" + next);
        return next;
    }

    /**
     * 负载均衡算法：rest接口的第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标，
     * 每次服务器重启后rest接口从1开始
     *
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        //取余
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
