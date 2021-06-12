package com.dylan.learnsynccode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author Dylan
 * @Date : 2021/6/11 - 22:38
 * @Description : 配置类，通过URI找到对应的handler，匹配URI的规则（Post Get）
 * @Function :
 */
@Configuration
public class FluxRouter {

    // Router约等于Controller注解 + RequestMapping注解 方法和类上的
    // 每个Router 对应的是一个handler
    // 每个handler代表一个处理器，Controller里的方法
    @Bean
    public RouterFunction<ServerResponse> routerFlux(FluxHandler fluxHandler){
        return RouterFunctions
                // predicate匹配规则
                .route(RequestPredicates.path("/001")
                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN))
                        , request->ServerResponse.ok().body(BodyInserters.fromValue("HelloWorld")))
                .andRoute(RequestPredicates.GET("/002"),fluxHandler::getXXX)
                .andRoute(RequestPredicates.GET("/003"), fluxHandler::getJsonXXX)
                .andRoute(RequestPredicates.GET("/004"), fluxHandler::getParams)
                .andRoute(RequestPredicates.GET("/005/{id}_{name}"), fluxHandler::getPathVariable)
               ;
    }

}
