package com.yscp.catchtable.application.reserve;

import com.yscp.catchtable.application.queue.dto.StoreQueueDto;
import com.yscp.catchtable.application.redis.RedisLockService;
import com.yscp.catchtable.application.reserve.mapper.StoreReserveMapper;
import com.yscp.catchtable.presentation.reserve.dto.StoreReserveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class UserReserveAggregateService {
    private final UserReserveService userReserveService;
    private final RedisLockService redisLockService;

    public void reserve(StoreReserveRequestDto storeReserveRequestDto) {
        StoreQueueDto storeQueueDto = new StoreQueueDto(storeReserveRequestDto.storeReserveIdx().toString(),
                storeReserveRequestDto.userIdx().toString());

        redisLockService.lock(
                () -> userReserveService.reserve(StoreReserveMapper.toDto(storeReserveRequestDto, LocalDateTime.now())),
                storeQueueDto.reserveKey(),
                2L,
                3L,
                TimeUnit.SECONDS
        );


    }
}
