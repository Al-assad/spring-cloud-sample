package site.assad.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * key 分解器
 *
 * @author yulinying
 * @since 2020/11/3
 */
@Configuration
public class Config {
    
    /**
     * 用户名称解析
     */
    @Bean
    @Qualifier("userKeyResolver")
    public KeyResolver userKeyResolver(){
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("name"));
    }

}
