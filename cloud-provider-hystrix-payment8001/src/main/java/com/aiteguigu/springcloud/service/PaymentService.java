package com.aiteguigu.springcloud.service;

import org.springframework.stereotype.Service;

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
    public String paymentInfo_TimeOut(Integer id) {
        Integer minutes = 3;
        try {
            Thread.sleep(minutes);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "  paymentInfo_TimeOut,id" + id + "\t" + "~.~,耗时" + minutes + "秒钟";
    }
}
