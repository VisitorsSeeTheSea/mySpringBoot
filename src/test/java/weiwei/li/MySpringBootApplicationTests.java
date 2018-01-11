package weiwei.li;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import weiwei.li.model.Book;
import weiwei.li.mongodb.impl.MongodbServiceImpl;
import weiwei.li.mq.Producer;

import javax.jms.Destination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpringBootApplicationTests {


    @Autowired
    private Producer producer;
    @Autowired
    private MongodbServiceImpl mongodbServiceImpl;


    @Test
    public void contextLoads() {

        Destination destination = new ActiveMQQueue("mytest.queue");
        Destination topic = new ActiveMQTopic("mytest.topic");

        for (int i = 0; i < 10; i++) {

            producer.sendMessage(destination, "发送queue消息" + i);
            producer.sendMessage(topic, "发送topic消息" + i);

        }
    }

    @Test
    public void testMongodb() {
        Book book = new Book();
        book.setId(1090L);
        book.setAuthor("hah");
        book.setReader("reader");
        book.setDescription("mongodb插入数据");
        mongodbServiceImpl.insertBook(book);

    }
}
