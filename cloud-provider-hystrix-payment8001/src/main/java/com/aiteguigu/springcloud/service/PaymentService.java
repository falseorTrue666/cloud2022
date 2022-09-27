package com.aiteguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @program: cloud2022
 * @ClassName PaymentService
 * @description:
 * @author: rrp
 * @create: 2022-09-26 21:51
 * @Version 1.0
 **/
@Service
public class PaymentService {

    /**
     * 正常访问，ok
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "  paymentInfo_OK,id" + id + "\t" + ".=.";
    }

    /**
     * 超时访问，ok
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
            })
    public String paymentInfo_TimeOut(Integer id) {
//        Integer seconds = 5;
        int age = 10/0;
        /*try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "线程池：" + Thread.currentThread().getName() + "  paymentInfo_TimeOut,id" + id + "\t" + "~.~,耗时" /*+ seconds + "秒钟"*/;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "  系统繁忙,请稍后再试,id" + id + "\t" + "fallback";
    }
}
