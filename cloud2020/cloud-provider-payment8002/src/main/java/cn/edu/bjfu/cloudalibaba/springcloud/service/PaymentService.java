package cn.edu.bjfu.cloudalibaba.springcloud.service;

import cn.edu.bjfu.cloudalibaba.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Chaos
 * @date 2021/3/29
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
