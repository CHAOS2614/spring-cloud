package cn.edu.bjfu.cloudalibaba.springcloud.dao;

import cn.edu.bjfu.cloudalibaba.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Chaos
 * @date 2021/3/29
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
