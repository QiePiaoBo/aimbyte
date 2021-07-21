package com.dylan.learnspring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;


/**
 * @author Dylan
 * @Date : Created in 10:49 2021/7/19
 * @Description :
 * @Function :
 */
@Component
public class RedisSubListener implements MessageListener {

    /**
     * 引入redisTemplate
     */
    @Autowired(required = false)
    private StringRedisTemplate redisTemplate;


    /**
     * 日志工具
     */
    Logger logger = LoggerFactory.getLogger(RedisSubListener.class);


    /**
     * 重写消息监听方法
     * @param message
     * @param bytes
     */
    @Override
    public void onMessage(Message message, byte[] bytes) {
        String msgString = (String) redisTemplate.getValueSerializer().deserialize(message.getBody());
        String channel = (String) redisTemplate.getValueSerializer().deserialize(message.getChannel());
        logger.info("Message String : " + msgString);
        logger.info("Channel of message : " + channel);
        if (null != channel && channel.contains(RedisCommonProperties.ChannelName)){
            logger.info("I can see the message : " + msgString);
        }
    }

    /**
     * 消息监听器
     * @param factory
     * @param redisSubListener
     * @return
     */
    @Bean(destroyMethod = "destroy")
    public RedisMessageListenerContainer container(RedisConnectionFactory factory, MessageListener redisSubListener){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.addMessageListener(redisSubListener, new PatternTopic(RedisCommonProperties.ChannelName));
        return container;
    }


}
