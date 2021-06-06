package com.dylan.learnspring.service.strategy;

import org.springframework.stereotype.Service;

@Service
public interface PrizeSender {

    String send(LSpringRequest request);

}
