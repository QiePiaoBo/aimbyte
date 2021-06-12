package com.dylan.learnsynccode.test;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author Dylan
 * @Date : 2021/6/10 - 22:27
 * @Description :
 * @Function :
 */
public class RXJavaTest01 {


    public static void main(String[] args) {

        Observable<String> girl = Observable.create(observableEmitter -> {
            observableEmitter.onNext("起床");
            observableEmitter.onNext("洗澡");
            observableEmitter.onNext("化妆");
            observableEmitter.onNext("出门");
            observableEmitter.onError(new Exception("晚上酒店805见。"));
            observableEmitter.onComplete();
        });

        Observer<String> man = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {
                System.out.println("onSubscribe " + disposable);
            }

            @Override
            public void onNext(@NonNull String s) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("监控报告: ");
                System.out.println("目标正在" + s);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("卧槽，她说" + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };


        girl.subscribe(man);


    }



}
