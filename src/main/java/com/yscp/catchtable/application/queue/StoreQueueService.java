package com.yscp.catchtable.application.queue;

import com.yscp.catchtable.application.queue.dto.StoreQueueDto;
import com.yscp.catchtable.exception.BadRequestError;
import com.yscp.catchtable.exception.CatchTableException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class StoreQueueService {
    private final RedisTemplate<String, String> redisTemplate;

    public void registerWaiting(StoreQueueDto storeQueueDto) {

        Boolean result = redisTemplate.opsForZSet().addIfAbsent(storeQueueDto.key(),
                storeQueueDto.value(),
                storeQueueDto.score());

        if (Boolean.FALSE.equals(result)) {
            throw new CatchTableException(BadRequestError.ALREADY_REGISTER_WAITING);
        }

        redisTemplate.expire(storeQueueDto.key(), Duration.ofMinutes(7L));

    }
}
