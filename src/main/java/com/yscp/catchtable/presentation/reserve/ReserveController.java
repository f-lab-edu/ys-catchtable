package com.yscp.catchtable.presentation.reserve;

import com.yscp.catchtable.application.reserve.ReserveService;
import com.yscp.catchtable.application.reserve.ReservesInDayDto;
import com.yscp.catchtable.presentation.reserve.dto.response.ReserveInDayResponseDtos;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
public class ReserveController {

    private final ReserveService reserveService;

    @GetMapping("/store/reserves/{storeIdx}")
    public ResponseEntity<ReserveInDayResponseDtos> getReservesInDay(@PathVariable Long storeIdx,
                                                                     @RequestParam LocalDate date) {

        ReservesInDayDto reservesInDay = reserveService.getReservesInDay(storeIdx, date);

        return ResponseEntity.ok(ReserveInDayResponseDtos.from(reservesInDay));
    }
}
