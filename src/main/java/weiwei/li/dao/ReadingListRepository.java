package weiwei.li.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import weiwei.li.model.Book;

import java.util.List;

/**
 * @author weiwei.li
 * @date 2017/12/19.
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);

}
