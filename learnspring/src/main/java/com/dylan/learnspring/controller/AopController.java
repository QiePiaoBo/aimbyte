package com.dylan.learnspring.controller;

import com.dylan.learnspring.myannotation.DoneTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @author Dylan
 * @Date : 2021/7/24 - 15:20
 * @Description :
 * @Function :
 */
@RestController
@RequestMapping("testAop")
public class AopController {

    @RequestMapping("do")
    @DoneTime(param = "ConditionController")
    public String condition(String type) throws Exception {
        if ("1".equals(type.toLowerCase(Locale.ROOT))){
            return "CommonCondition test end.";
        }else {
            throw new Exception("Testing exception for aop.");
        }
    }

}
