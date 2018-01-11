package weiwei.li.service.impl;

import org.springframework.stereotype.Service;
import weiwei.li.model.Book;
import weiwei.li.service.HessianService;

/**
 * @author weiwei.li
 * @date 2017/12/27.
 */
@Service("HessianService")
public class HessianServiceImpl implements HessianService {
    @Override
    public Book getBook() {
        Book book = new Book();
        book.setReader("liweiwie");
        book.setAuthor("weiwei.li");
        System.out.println("hello!");
        return book;
    }
}
