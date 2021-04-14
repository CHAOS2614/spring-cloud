package cn.edu.bjfu.cloudalibaba.springcloud.controller;

import cn.edu.bjfu.cloudalibaba.springcloud.entity.CommonResult;
import cn.edu.bjfu.cloudalibaba.springcloud.entity.Payment;
import cn.edu.bjfu.cloudalibaba.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Chaos
 * @date 2021/3/29
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info(new Date() + "--->插入结果:" + result);
        if (result > 0) {
            return new CommonResult<>(200, "插入成功,服务端口号为:" + serverPort, result);
        } else {
            return new CommonResult<>(440, "插入失败", result);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        log.info("接收到id:" + id);
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功,服务端口号为:" + serverPort, payment);
        } else {
            return new CommonResult<>(440, "无数据");
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLb(){
        return serverPort;
    }
}
