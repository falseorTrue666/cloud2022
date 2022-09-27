package com.aiteguigu.springcloud.service.impl;

import com.aiteguigu.springcloud.dao.PaymentDao;
import com.aiteguigu.springcloud.entities.Payment;
import com.aiteguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: cloud2022
 * @ClassName PaymentServiceImpl
 * @description:
 * @author: rrp
 * @create: 2022-09-19 15:01
 * @Version 1.0
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    /**
     * 保存
     *
     * @param payment
     * @return
     */
    @Override
    public int save(Payment payment) {
        return paymentDao.save(payment);
    }

    /**
     * 获取
     *
     * @param id
     * @return
     */
    @Override
    public Payment getPaymentList(Long id) {
        return paymentDao.getPaymentList(id);
    }
}
