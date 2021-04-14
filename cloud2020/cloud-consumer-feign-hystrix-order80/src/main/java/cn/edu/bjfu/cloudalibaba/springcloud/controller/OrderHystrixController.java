package cn.edu.bjfu.cloudalibaba.springcloud.controller;

import cn.edu.bjfu.cloudalibaba.springcloud.serevice.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Chaos
 * @date 2021/4/9
 */
@RestController
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id)
    {
        return paymentHystrixService.paymentOk(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentTimeOut(@PathVariable("id") Integer id)
    {
        return paymentHystrixService.paymentTimeOut(id);
    }

}
