package lab.nice.owo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import lab.nice.owo.service.IDService;

@Service
public class TimelineIDService implements IDService<Long> {
    private RedisAtomicLong redisAtomicLong;

    @Autowired
    public TimelineIDService(RedisConnectionFactory connectionFactory) {
        super();
        this.redisAtomicLong = new RedisAtomicLong("TIMELINE_ID_SEQ", connectionFactory);
    }

    @Override
    public Long nextID() {
        return redisAtomicLong.incrementAndGet();
    }
}
