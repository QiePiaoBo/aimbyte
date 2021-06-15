package com.dylan.learnsynccode.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @Date : Created in 10:00 2021/6/15
 * @Description :
 * @Function :
 */
@Configuration
public class RouteLocatorTest {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        Map<String, String> data = new HashMap<>();
        data.put("Name", "Dylan");
        data.put("Age", "24");
        RouterFunction<ServerResponse> route = RouterFunctions
                .route(RequestPredicates.path("/006"),
                        req -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(BodyInserters.fromValue("006")))
                .andRoute(RequestPredicates.path("/007"),
                        req-> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(data)))
                .andRoute(RequestPredicates.path("/008"),
                        req-> ServerResponse.ok().contentType(MediaType.TEXT_HTML).body(BodyInserters.fromValue("<h1>008</h1>")))

                ;
        return route;
    }
}
