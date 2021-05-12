package com.dylan.learnrpc.roktmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
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
public class Producer1 {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer mqProducer = new DefaultMQProducer("xoxogp");
        // 设置nameserver的地址
        mqProducer.setNamesrvAddr("192.168.110.110:9876");
        mqProducer.start();
        mqProducer.setRetryTimesWhenSendAsyncFailed(1000);

        // 异步可靠消息
        // 不会阻塞等待broker的确认
        // 采用事件监听的方式接收broker返回的确认
        Message message = new Message("test_topic", "HelloWorld001".getBytes(StandardCharsets.UTF_8));
        mqProducer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功");
                System.out.println(sendResult);
                mqProducer.shutdown();
                System.out.println("已经停机");
            }

            @Override
            public void onException(Throwable e) {
                // 如果发生异常，尝试重投
                // 或者调整业务逻辑
                e.printStackTrace();
            }
        });

    }



}
