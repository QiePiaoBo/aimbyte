package com.dylan.learnspring.service.test;


public class IntegralSender implements PrizeSender {

    @Override
    public String send(LSpringRequest request) {
        return "Score.integral";
    }

}
