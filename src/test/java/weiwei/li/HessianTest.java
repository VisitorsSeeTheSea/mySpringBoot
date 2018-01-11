package weiwei.li;

import com.caucho.hessian.client.HessianProxyFactory;
import weiwei.li.model.Book;
import weiwei.li.service.HessianService;

import java.net.MalformedURLException;

/**
 * @author weiwei.li
 * @date 2017/12/27.
 */
public class HessianTest {

    private static final String urlName = "http://127.0.0.1:8080/HessianService";
    //    private static final String urlName = "http://172.20.10.16:17833/finance/pingan";
    private static HessianService hessianService;

    static {
        HessianProxyFactory factory = new HessianProxyFactory();
        try {
            hessianService = (HessianService) factory.create(HessianService.class, urlName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Book book = hessianService.getBook();

        System.out.println(book.toString());

    }
}
