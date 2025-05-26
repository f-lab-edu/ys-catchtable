package com.yscp.catchtable.application.redis;

import com.yscp.catchtable.exception.BadRequestError;
import com.yscp.catchtable.exception.CatchTableException;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class RedisLockService {
    private final RedissonClient redissonClient;

    public void lock(Runnable runnable,
                     String key,
                     long waitTime,
                     long leaseTime,
                     TimeUnit unit) {
        RLock lock = redissonClient.getLock(key);

        try {
            if (lock.tryLock(waitTime, leaseTime, unit)) {
                try {
                    runnable.run();
                } finally {
                    lock.unlock();
                }
            } else {
                throw new CatchTableException(BadRequestError.ALREADY_RESERVE);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
