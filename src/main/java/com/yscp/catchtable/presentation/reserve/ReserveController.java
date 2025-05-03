package com.yscp.catchtable.presentation.reserve;

import com.yscp.catchtable.application.reserve.ReserveService;
import com.yscp.catchtable.application.reserve.ReservesInDayDto;
import com.yscp.catchtable.application.reserve.UserReserveService;
import com.yscp.catchtable.application.reserve.mapper.StoreReserveMapper;
import com.yscp.catchtable.presentation.reserve.dto.StoreReserveRequestDto;
import com.yscp.catchtable.presentation.reserve.dto.response.ReserveInDayResponseDtos;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
public class ReserveController {

    private final UserReserveService reserveService;

    @GetMapping("/store/reserves/{storeIdx}")
    public ResponseEntity<ReserveInDayResponseDtos> getReservesInDay(@PathVariable Long storeIdx,
                                                                     @RequestParam LocalDate date) {

        ReservesInDayDto reservesInDay = reserveService.getReservesInDay(storeIdx, date);

        return ResponseEntity.ok(ReserveInDayResponseDtos.from(reservesInDay));
    }

    @PostMapping("/store/reserves/{storeIdx}")
    public ResponseEntity<Void> reserve(@PathVariable Long storeIdx,
                                        @RequestBody StoreReserveRequestDto storeReserveRequestDto) {
        StoreReserveMapper.toDto(storeReserveRequestDto);
        reserveService.reserve(StoreReserveMapper.toDto(storeReserveRequestDto));
        return ResponseEntity.ok().build();
    }
}
