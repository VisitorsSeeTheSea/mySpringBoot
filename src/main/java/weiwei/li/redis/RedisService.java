package weiwei.li.redis;

import weiwei.li.model.Book;

/**
 * @author weiwei.li
 * @date 2017/12/27.
 */
public interface RedisService {

    public void set(String key, Object value);

    public Object get(String key);

    public void setHas(String key, String id, Book book);

    public Book getUser(String key, String id);
}
