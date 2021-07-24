package com.dylan.learnrpc.roktmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @author Dylan
 * @Date : 2021/5/10 - 21:09
 * @Description :
 * @Function :
 */
public class Consumer {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
        consumer.setNamesrvAddr("192.168.110.110:9876");

        // 每个consumer关注一个topic

        // topic 关注的消息的地址
        // 过滤器 * 表示不过滤
        consumer.subscribe("test_topic", "tag1");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt msg : msgs){
                    byte[] body = msg.getBody();
                    System.out.println(new String(body));
                }
                // 默认情况下 这条消息只会被一个consumer消费到 点对点
                // message修改状态
                // ack
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        System.out.println("Consumer 00 start.");
        // 集群消费模式，在一组consumer中，只要有一个consumer消费了一次，就不再消费了
        // consumer.setMessageModel(MessageModel.CLUSTERING);
        // 广播消费模式，所有绑定了当前topic的consumer都能得到一次消费的机会
        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.start();
    }

}
