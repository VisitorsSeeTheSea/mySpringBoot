package weiwei.li.mongodb;

import weiwei.li.model.Book;

/**
 * @author weiwei.li
 * @date 2018/1/11.
 */
public interface MongodbService {
    void insertBook(Book book);

    Book getBookById(Book book);


}
