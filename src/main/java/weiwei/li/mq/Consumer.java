package weiwei.li.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author weiwei.li
 * @date 2018/1/8.
 * http://blog.csdn.net/liuchuanhong1/article/details/72726337
 * pubSubDomain: 此消费通道是否为Topic，默认为“false”。所有与Topic有关的属性，只有在pubSubDomain为true的情况下生效。 但是设置成top消息 普通消息会收不到 所以要
 * 创建两个JmsListenerContainerFactory，分别是topicListenerFactory和queueListenerFactory， 在注册监听的时候指定使用哪种
 */
@Component
public class Consumer {
    //     使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "mytest.queue",containerFactory = "queueListenerFactory")// 增加对应处理的监听器工程
    public void receiveQueue(String text) {
        System.out.println("mySpringBoot项目接收到queue 消息:" + text);
    }


    @JmsListener(destination = "mytest.topic",containerFactory = "topicListenerFactory")// 增加对应处理的监听器工程
    public void receiveTopic(TextMessage text) throws JMSException {
        System.out.println("topic 消息:" + text.getText());
    }
}