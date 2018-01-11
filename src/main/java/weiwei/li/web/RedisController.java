package weiwei.li.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import weiwei.li.dao.ReadingListRepository;
import weiwei.li.model.Book;
import weiwei.li.redis.RedisService;

import java.security.cert.TrustAnchor;
import java.util.List;

/**
 * @author weiwei.li
 * @date 2017/12/19.
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public String addToReadingList() {
//        redisService.set("1414", "110");

//        System.out.println("hahah" + redisService.get("1414"));

        return "save";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.GET)
    @ResponseBody
    public String saveuser() {
        Book book = new Book();
        book.setReader("wo");
        book.setAuthor("haha");
        redisService.setHas("USER", "abc123", book);
        return "save";
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ResponseBody
    public String getUser() {

        Book book = redisService.getUser("USER", "abc123");
        return book.toString();
    }


}
