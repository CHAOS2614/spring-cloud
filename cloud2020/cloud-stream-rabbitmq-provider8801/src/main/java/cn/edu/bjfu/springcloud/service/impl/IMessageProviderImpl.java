package cn.edu.bjfu.springcloud.service.impl;

import cn.edu.bjfu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @author Chaos
 * @date 2021/4/13
 */
@EnableBinding(Source.class)
public class IMessageProviderImpl implements IMessageProvider {

    /**
     * 消息的发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        // 创建并发送消息
        this.output.send(MessageBuilder.withPayload(serial).build());
        System.out.println(new Date() + "---------->serial:" + serial);
        return serial;
    }
}