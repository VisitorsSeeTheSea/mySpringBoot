package weiwei.li.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import weiwei.li.dao.ReadingListRepository;
import weiwei.li.model.Book;
import weiwei.li.mongodb.impl.MongodbServiceImpl;

import java.util.List;

/**
 * @author weiwei.li
 * @date 2017/12/19.
 */
@Controller
@RequestMapping("/")
public class ReadingListController {
    private ReadingListRepository readingListRepository;


    @Autowired
    public ReadingListController(
            ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;

    }


    @RequestMapping(value = "/read", method = RequestMethod.GET)
    @ResponseBody
    public String readersBooks() {
        List<Book> readingList =
                readingListRepository.findByReader("1");
        readingList.stream().forEach(p -> System.out.println("reader:" + p.getReader()));

        return "readingList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public String addToReadingList() {
        System.out.println("hahahha");
        Book book = new Book();
        book.setReader("1");
        try {
            readingListRepository.save(book);
        } catch (Exception e) {
            System.out.println("yichang" + e);
        }
        return "save";
    }


}
