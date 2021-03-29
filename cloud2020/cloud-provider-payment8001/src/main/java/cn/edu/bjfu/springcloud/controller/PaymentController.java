package cn.edu.bjfu.springcloud.controller;

import cn.edu.bjfu.springcloud.entity.CommonResult;
import cn.edu.bjfu.springcloud.entity.Payment;
import cn.edu.bjfu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(Payment payment) {
        int result = paymentService.create(payment);
        log.info(new Date() + "--->插入结果:" + result);
        if (result > 0 ){
            return new CommonResult<>(200,"插入成功",result);
        }else {
            return new CommonResult<>(440,"插入失败",result);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null){
            return new CommonResult<>(200,"查询成功",payment);
        }else {
            return new CommonResult<>(440,"无数据");
        }
    }
}