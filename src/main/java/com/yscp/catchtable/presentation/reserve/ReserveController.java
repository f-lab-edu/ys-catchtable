package com.yscp.catchtable.presentation.reserve;

import com.yscp.catchtable.application.queue.dto.StoreQueueDto;
import com.yscp.catchtable.application.reserve.ReserveService;
import com.yscp.catchtable.application.reserve.ReservesInDayDto;
import com.yscp.catchtable.application.reserve.UserReserveService;
import com.yscp.catchtable.application.reserve.mapper.StoreReserveMapper;
import com.yscp.catchtable.exception.BadRequestError;
import com.yscp.catchtable.exception.CatchTableException;
import com.yscp.catchtable.presentation.reserve.dto.StoreReserveRequestDto;
import com.yscp.catchtable.presentation.reserve.dto.response.ReserveInDayResponseDtos;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@RestController
public class ReserveController {
    private final UserReserveService userReserveService;
    private final ReserveService reserveService;
    private final RedissonClient redissonClient;

    @GetMapping("/store/reserves/{storeIdx}")
    public ResponseEntity<ReserveInDayResponseDtos> getReservesInDay(@PathVariable Long storeIdx,
                                                                     @RequestParam LocalDate date) {

        ReservesInDayDto reservesInDay = reserveService.getReservesInDay(storeIdx, date);

        return ResponseEntity.ok(ReserveInDayResponseDtos.from(reservesInDay));
    }

    @PostMapping("/store/reserves")
    public ResponseEntity<Void> reserve(@RequestBody StoreReserveRequestDto storeReserveRequestDto) {
        StoreQueueDto storeQueueDto = new StoreQueueDto(storeReserveRequestDto.storeReserveIdx().toString(), storeReserveRequestDto.userIdx().toString());
        RLock lock = redissonClient.getLock(storeQueueDto.key());
        try {
            if (lock.tryLock(1, 3, TimeUnit.SECONDS)) {
                try {
                    userReserveService.reserve(StoreReserveMapper.toDto(storeReserveRequestDto, LocalDateTime.now()));

                } finally {
                    lock.unlock();
                }
            } else {
                throw new CatchTableException(BadRequestError.ALREADY_RESERVE);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return ResponseEntity.ok().build();
    }
}
