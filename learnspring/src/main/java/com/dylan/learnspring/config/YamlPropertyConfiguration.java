package com.dylan.learnspring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Dylan
 * @Date : Created in 9:13 2021/6/7
 * @Description :
 * @Function :
 */
@Component
@ConfigurationProperties(prefix = "testyaml")
public class YamlPropertyConfiguration {

    private Map<String, String > yamlMap;

    public Map<String, String> getYamlMap() {
        return yamlMap;
    }

    public void setYamlMap(Map<String, String> yamlMap) {
        this.yamlMap = yamlMap;
    }
}
