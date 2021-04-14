package cn.edu.bjfu.cloudalibaba.springcloud.service;

import cn.edu.bjfu.cloudalibaba.springcloud.entity.CommonResult;
import cn.edu.bjfu.cloudalibaba.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Chaos
 * @date 2021/4/9
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

}
