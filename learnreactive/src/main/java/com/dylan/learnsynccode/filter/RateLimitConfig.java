package com.dylan.learnsynccode.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author Dylan
 * @Date : 2021/6/15 - 23:03
 * @Description :
 * @Function :
 */
@Configuration
public class RateLimitConfig {

    @Bean
    KeyResolver userKeyResolver(){
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getQueryParams().getFirst("user")));
    }
}
