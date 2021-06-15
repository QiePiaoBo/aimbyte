package com.dylan.learnsynccode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Dylan
 * @Date : 2021/6/10 - 23:47
 * @Description :
 * @Function :
 */
@RestController
@RequestMapping("test")
public class TestController {


    @RequestMapping("1")
    public Mono<String> getMonoString(String name){

        System.out.println("---step1---");
        Mono<String> res = Mono.create(sink->{
            sink.success(prepareData(name));
        });
        System.out.println("---step2---");
        System.out.println(name);

        return res;
    }

    public String prepareData(String name){
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Hello " + name + ".";
    }
}
