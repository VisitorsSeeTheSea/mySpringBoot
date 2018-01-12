package weiwei.li;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author kanhai@anve.com
 * @date 2018/1/12.
 */
public class Demo {

    public static void main(String[] args) {
        FileReader fr = null;
        try {
            //1.输入流读取文件
            fr = new FileReader("/Users/weiwei.li/Desktop/data.txt");
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
