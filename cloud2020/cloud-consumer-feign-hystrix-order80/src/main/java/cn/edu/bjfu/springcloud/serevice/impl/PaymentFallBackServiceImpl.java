package cn.edu.bjfu.springcloud.serevice.impl;

import cn.edu.bjfu.springcloud.serevice.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author Chaos
 * @date 2021/4/9
 */
@Component
public class PaymentFallBackServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentOk(Integer id) {
        return id.toString();
    }

    @Override
    public String paymentTimeOut(Integer id) {
        return id.toString();
    }
}
