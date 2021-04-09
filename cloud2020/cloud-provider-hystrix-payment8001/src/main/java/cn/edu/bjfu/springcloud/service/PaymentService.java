package cn.edu.bjfu.springcloud.service;

import org.springframework.stereotype.Service;

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

    public String paymentTimeOut(Integer id) {
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + " paymentTime_Out,id: " + id + " o(╥﹏╥)o " + time;
    }
}
