package cn.edu.bjfu.springcloud.service;

import cn.edu.bjfu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Chaos
 * @date 2021/3/29
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
