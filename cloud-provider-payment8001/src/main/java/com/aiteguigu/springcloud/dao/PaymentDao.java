package com.aiteguigu.springcloud.dao;

import com.aiteguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: cloud2022
 * @ClassName PaymentDao
 * @description:
 * @author: rrp
 * @create: 2022-09-19 14:30
 * @Version 1.0
 **/
@Mapper
public interface PaymentDao {

    /**
     * 保存
     * @param payment
     * @return
     */
    public int save(Payment payment);

    /**
     * 获取
     * @param id
     * @return
     */
    public Payment getPaymentList(@Param("id") Long id);
}
