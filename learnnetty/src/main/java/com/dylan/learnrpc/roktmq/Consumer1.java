package com.dylan.learnrpc.roktmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
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
public class Consumer1 {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
        consumer.setNamesrvAddr("192.168.110.110:9876");

        // 每个consumer关注一个topic

        // topic 关注的消息的地址
        // 过滤器 * 表示不过滤
        MessageSelector bySql = MessageSelector.bySql("age >= 18 and age <= 28");
        consumer.subscribe("test_topic05", bySql);
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
        System.out.println("Consumer 01 start.");
        consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.start();
    }

}
