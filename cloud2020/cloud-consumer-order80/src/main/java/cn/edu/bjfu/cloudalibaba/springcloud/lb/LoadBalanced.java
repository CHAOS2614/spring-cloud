package cn.edu.bjfu.cloudalibaba.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Chaos
 * @date 2021/4/2
 */
public interface LoadBalanced {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
