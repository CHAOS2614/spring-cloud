package cn.edu.bjfu.cloudalibaba.springcloud.lb.impl;

import cn.edu.bjfu.cloudalibaba.springcloud.lb.LoadBalanced;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Chaos
 * @date 2021/4/2
 */
@Component
public class MyLoadBalanced implements LoadBalanced {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){

        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 :current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println(new Date() + "------>第" + next + "次访问");
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size() ;
        return serviceInstances.get(index);
    }

}
