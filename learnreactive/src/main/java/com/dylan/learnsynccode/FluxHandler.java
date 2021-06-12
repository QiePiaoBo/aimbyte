package com.dylan.learnsynccode;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Dylan
 * @Date : 2021/6/11 - 22:43
 * @Description :
 * @Function :
 */
@Component
public class FluxHandler {

    public Mono<ServerResponse> getXXX(ServerRequest request){
        // 业务逻辑
        return
            ServerResponse.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(BodyInserters.fromValue("asda"));
    }

    /**
     * 返回json
     * @param request
     * @return
     */
    public Mono<ServerResponse> getJsonXXX(ServerRequest request){
        Person person = new Person("Dylan", 24, 1);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(person));
    }

    /**
     * path中获取变量参数
     * @param request
     * @return
     */
    public Mono<ServerResponse> getParams(ServerRequest request){
        Optional<String> paramId = request.queryParam("id");
        System.out.println("id: " + paramId);

        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(BodyInserters.fromValue("ok"));
    }

    /**
     * 取路径中的变量
     * @param request
     * @return
     */
    public Mono<ServerResponse> getPathVariable(ServerRequest request){
        String id = request.pathVariable("id");
        String name = request.pathVariable("name");
        Map<String, String> res = new HashMap<>();
        res.put("id", id);
        res.put("name", name);
        System.out.println(res);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(res));
    }
}