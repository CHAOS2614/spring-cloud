package cn.edu.bjfu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Chaos
 * @date 2021/4/9
 * 节约时间不写接口了
 */
@Service
public class PaymentService {

    public String paymentOk(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " payment_Ok,id: " + id + " ^_^ ";
    }

    /**
     * 超过三秒则认定超时，调用兜底方法
     */
    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentTimeOut(Integer id) {
        int time = 5;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + " paymentTime_Out,id: " + id + " o(╥﹏╥)o " + time;
    }

    public String paymentTimeoutHandler(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " paymentTimeoutHandler,id: " + id + new Date();
    }
}
