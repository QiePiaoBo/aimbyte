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
    public Mono<String> getMonoString(){

        System.out.println("---step1---");
        Mono<String> res = Mono.create(sink->{
            sink.success(prepareData());
        });
        System.out.println("---step2---");

        return res;
    }

    public String prepareData(){
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Hello world";
    }
}
