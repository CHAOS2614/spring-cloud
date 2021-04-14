package cn.edu.bjfu.cloudalibaba.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author Chaos
 * @date 2021/4/12
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info(new Date() + "---------->全局日志过滤器！");
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname == null){
            log.info(new Date() + "---------->用户名不能为null！");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 过滤器优先级，越小越高
     * @return 优先级
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
