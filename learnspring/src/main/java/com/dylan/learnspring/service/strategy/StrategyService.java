package com.dylan.learnspring.service.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @Date : 2021/2/28 - 13:07
 * @Description :
 * @Function :
 */
@Service
public class StrategyService {

    private static final Logger logger = LoggerFactory.getLogger(StrategyService.class);

    private static Map<String, PrizeSender> eventServiceMap = new HashMap<>();

    static {
        eventServiceMap.put("0", new VirtualMoneySender());
        eventServiceMap.put("1", new MoneySender());
        eventServiceMap.put("2", new IntegralSender());
    }

    /**
     * 根据不同的参数从map中提取不同的执行器以执行对应的策略
     * @param lSpringRequest
     * @return
     */
    public Object doEvent(LSpringRequest lSpringRequest){
        if (null == eventServiceMap.get(lSpringRequest.getType())){
            return "Error, valid way not found.";
        }
        return eventServiceMap.get(lSpringRequest.getType()).send(lSpringRequest);
    }
}
