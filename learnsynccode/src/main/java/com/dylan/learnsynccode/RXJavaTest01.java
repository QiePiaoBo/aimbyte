package com.dylan.learnsynccode;


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

        Observable<String> girl = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("A");
                Thread.sleep(1000);
                observableEmitter.onNext("A");
                observableEmitter.onNext("A");
                observableEmitter.onNext("A");
                observableEmitter.onError(new Exception("AAA"));
                observableEmitter.onComplete();
            }
        });

        Observer<String> man = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {
                System.out.println("onSubscribe " + disposable);
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("onNext " + s);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {
                System.out.println("onError " + throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };


        girl.subscribe(man);


    }



}
