package com.dylan.learnrpc.roktmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * @author Dylan
 * @Date : 2021/5/10 - 20:54
 * @Description :
 * @Function :
 */
public class Producer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer mqProducer = new DefaultMQProducer("xoxogp");
        // 设置nameserver的地址
        mqProducer.setNamesrvAddr("192.168.110.110:9876");
        mqProducer.start();

        // topic 消息将要发送到的地址
        // body 消息中的具体数据
        String topic;
        Message message1 = new Message("test_topic", "HelloWorld001".getBytes(StandardCharsets.UTF_8));
        Message message2 = new Message("test_topic", "HelloWorld002".getBytes(StandardCharsets.UTF_8));
        Message message3 = new Message("test_topic", "HelloWorld003".getBytes(StandardCharsets.UTF_8));

        ArrayList<Message> messages = new ArrayList<>();
        messages.add(message1);
        messages.add(message2);
        messages.add(message3);
        // 同步消息发送，发送不成功会一直阻塞到抛出异常不会丢消息
        SendResult result = mqProducer.send(messages);

        System.out.println(result);
        mqProducer.shutdown();
        System.out.println("已经停机");

    }



}
