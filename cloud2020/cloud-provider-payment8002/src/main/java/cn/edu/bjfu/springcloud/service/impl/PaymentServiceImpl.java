package cn.edu.bjfu.springcloud.service.impl;

import cn.edu.bjfu.springcloud.dao.PaymentDao;
import cn.edu.bjfu.springcloud.entity.Payment;
import cn.edu.bjfu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Chaos
 * @date 2021/3/29
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
