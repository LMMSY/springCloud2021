package com.springcloud.dao;

import entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public  Payment getId(@Param("id") Long id);
}
