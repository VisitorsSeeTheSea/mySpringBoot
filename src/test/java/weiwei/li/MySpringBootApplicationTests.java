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
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
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
        book.setId(1098L);
        book.setAuthor("hah");
        book.setReader("reader");
        book.setDescription("mongodb插入数据");
        mongodbServiceImpl.insertBook(book);

    }

    @Test
    public void file() {
        try {
            //1.输入流读取文件
            FileReader fr = new FileReader("/Users/weiwei.li/Desktop/data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            ArrayList<String> arrayList = new ArrayList();
            //2.一行一行读取文件内容 存入到list中
            while ((line = br.readLine()) != null) {
                arrayList.add(line);
            }


            //3.随机从集合中获取一个
            Random r = new Random();
            int index = r.nextInt(4);

            String language = arrayList.get(index);
            System.out.println("年度最受欢迎的语言是：" + language);


            br.close();
            fr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
