package com.dylan.learnrpc.roktmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

/**
 * @author Dylan
 * @Date : 2021/5/10 - 20:54
 * @Description :
 * @Function :
 */
public class Producer3 {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer mqProducer = new DefaultMQProducer("xoxogp");
        // 设置nameserver的地址
        mqProducer.setNamesrvAddr("192.168.110.110:9876");
        mqProducer.start();

        // topic 消息将要发送到的地址
        // body 消息中的具体数据
        // tag是用来过滤消息的，也可以理解为消息分组
        Message message1 = new Message("test_topic","tag2", "key-hello",  "HelloWorld002".getBytes(StandardCharsets.UTF_8));

        mqProducer.sendOneway(message1);
        // 单向消息，效率最高
        mqProducer.shutdown();
        System.out.println("已经停机");

    }



}
