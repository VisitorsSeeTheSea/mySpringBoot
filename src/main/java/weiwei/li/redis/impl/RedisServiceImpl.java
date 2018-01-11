package weiwei.li.redis.impl;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import weiwei.li.model.Book;
import weiwei.li.redis.RedisService;

import javax.annotation.Resource;

/**
 * @author weiwei.li
 * @date 2017/12/27.
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void set(String key, Object value) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
    }

    @Override
    public Object get(String key) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }


    @Override
    public void setHas(String key, String id, Book book) {
        HashOperations<String, String, Book> opsForHash = redisTemplate.opsForHash();
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("reader", "xsg");
//        map.put("author", "xxsg");
        opsForHash.put(key, id, book);
    }

    @Override
    public Book getUser(String key, String id) {
        return (Book) redisTemplate.opsForHash().get(key, id);
    }
}
