package com.dylan.learnspring.service.test;

import org.springframework.stereotype.Service;

@Service
public interface PrizeSender {

    String send(LSpringRequest request);

}
