package lab.nice.owo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import lab.nice.owo.service.IDService;

@Service
public class PostIDService implements IDService<Long> {
    private RedisAtomicLong redisAtomicLong;

    @Autowired
    public PostIDService(RedisConnectionFactory connectionFactory) {
        super();
        this.redisAtomicLong = new RedisAtomicLong("POST_ID_SEQ", connectionFactory);
    }

    @Override
    public Long nextID() {
        return redisAtomicLong.incrementAndGet();
    }
}
