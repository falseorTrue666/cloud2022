package com.aiteguigu.myRule;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: cloud2022
 * @ClassName MySelfRule
 * @description:
 * @author: rrp
 * @create: 2022-09-22 11:48
 * @Version 1.0
 **/
@Configuration
public class MySelfRule {

    @Bean
    public IRule getMySelfRule() {
        //随机
//        return new RandomRule();
        //轮询
        return new RoundRobinRule();
        //具备重试机制的实例选择功能
//        return new RetryRule();
        //权重   路由算法
//        return new WeightedResponseTimeRule();
        //最可用，选择负载最小的节点   在高并发，高流量业务场景下不适用
//        return new BestAvailableRule();
        //通过线性抽样的方式直接尝试可用且较空闲的实例来使用
//        return new AvailabilityFilteringRule();
        //依次使用次过滤条件对主过滤条件的结果进行过滤
        //不论是主过滤条件还是次过滤条件，都需要判断下面两个条件
        //只要有一个条件符合，就不再过滤，将当前结果返回供线性轮询
        //算法选择
            //第1个条件：过滤后的实例总数>=最小过滤实例数（默认为1）
            //第2个条件：过滤互的实例比例>最小过滤百分比（默认为0）
//        return new ZoneAvoidanceRule();
    }
}
