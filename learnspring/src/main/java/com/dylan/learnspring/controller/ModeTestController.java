package com.dylan.learnspring.controller;

import com.dylan.learnspring.service.test.LSpringRequest;
import com.dylan.learnspring.service.test.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试自定义的策略模式
 */
@RestController
@RequestMapping("modelTest")
public class ModeTestController {

    @Autowired
    private StrategyService strategyService;

    @RequestMapping("strategy")
    public String send(@RequestBody LSpringRequest request){
        return (String) strategyService.doEvent(request);
    }
}
