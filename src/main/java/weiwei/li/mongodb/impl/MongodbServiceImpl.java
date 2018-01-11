package weiwei.li.mongodb.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import weiwei.li.model.Book;
import weiwei.li.mongodb.MongodbService;

/**
 * @author weiwei.li
 * @date 2018/1/11.
 */
@Service
public class MongodbServiceImpl implements MongodbService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertBook(Book book) {

        mongoTemplate.insert(book);

    }

    @Override
    public Book getBookById(Book book) {
        return null;
    }
}
