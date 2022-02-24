package com.dylan.learnspring.controller;

import com.dylan.learnspring.config.YamlPropertyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Dylan
 * @Date : Created in 9:15 2021/6/7
 * @Description :
 * @Function :
 */
@RestController
@RequestMapping("ymlTest")
public class YamlController {

    @Resource
    private YamlPropertyConfiguration yamlPropertyConfiguration;


    @RequestMapping("test")
    public void testYaml(){
        Map<String, String> yamlMap = yamlPropertyConfiguration.getYamlMap();
        for (String s : yamlMap.keySet()){
            System.out.println(s + " : " + yamlMap.get(s));
        }
    }
}
