package com.dylan.learnsynccode.test;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Dylan
 * @Date : 2021/6/10 - 22:37
 * @Description :
 * @Function :
 */
public class RxJavaTest02 {

    public static void main(String[] args) {
        String[] s = new String[]{"aa", "bb"};
        // just 已知元素数量和内容
        Flux<String> flux1 = Flux.just(s);
        // println是发布者/订阅者的执行逻辑
        flux1.subscribe(System.out::println);
        flux1.subscribe(System.out::println);

        System.out.println("------");
        Flux<String> flux2 = Flux.just("cc", "dd", "ee");
        flux2.subscribe(System.out::println);
        System.out.println("------");
        List<String> list = Arrays.asList("hello","world");
        Flux<String> flux3 = Flux.fromIterable(list);
        flux3.subscribe(System.out::println);

        System.out.println("------");
        Stream<String> stream = Stream.of("hi", "hello");
        Flux<String> flux4 = Flux.fromStream(stream);
        flux4.subscribe(System.out::println);
        System.out.println("------");
        // 链式
        Flux.range(1, 5).subscribe(System.out::println);
        System.out.println("------");
        // 合并
        Flux<String> merged = flux1.mergeWith(flux3);
        merged.subscribe(System.out::println);

        System.out.println("------");
        // 同步动态创建，next只能调一次
        Flux.generate(sink->{
            sink.next("sink1");
            sink.complete();
        }).subscribe(System.out::println);
        System.out.println("------");
        // 异步动态创建
        Flux.create(fluxSink -> {
            for (int i = 0; i < 10; i++) {
                fluxSink.next("time: " + i);
            }
            fluxSink.complete();
        }).subscribe(System.out::println);

    }

}
