package com.springcloud.service;

import com.springcloud.dao.PaymentDao;
import entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int creat(Payment payment){

        return paymentDao.create(payment);
    }

    public  Payment getId( Long id){

        return paymentDao.getId(id);
    }

}
