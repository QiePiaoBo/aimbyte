package com.dylan.learnspring.service.strategy;

import org.springframework.stereotype.Service;

@Service
public class VirtualMoneySender implements PrizeSender{

    @Override
    public String send(LSpringRequest request) {
        return "Money.BitCoin";
    }

}
