package com.dylan.learnspring.service.test;


public class MoneySender implements PrizeSender {
    @Override
    public String send(LSpringRequest request) {
        return "Money.RMB";
    }
}
