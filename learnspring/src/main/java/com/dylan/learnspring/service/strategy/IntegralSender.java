package com.dylan.learnspring.service.strategy;


public class IntegralSender implements PrizeSender {

    @Override
    public String send(LSpringRequest request) {
        return "Score.integral";
    }

}
