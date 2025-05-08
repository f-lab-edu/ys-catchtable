package com.yscp.catchtable.application.queue;

import com.yscp.catchtable.application.queue.dto.StoreQueueDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StoreQueueService {
    private final RedisTemplate<String, String> redisTemplate;

    public void registerWaiting(StoreQueueDto storeQueueDto) {
        redisTemplate.opsForZSet().add(storeQueueDto.key(), storeQueueDto.value(), storeQueueDto.score());
    }

    public boolean isValidWaitingUser(StoreQueueDto storeQueueDto) {
        Double score = redisTemplate.opsForZSet().score(storeQueueDto.key(), storeQueueDto.value());
        long now = System.currentTimeMillis();
        return now - score <= 7 * 60 * 1000;
    }

    public void delete(StoreQueueDto storeQueueDto) {
        redisTemplate.opsForZSet().remove(storeQueueDto.key(), storeQueueDto.value());
    }
}
