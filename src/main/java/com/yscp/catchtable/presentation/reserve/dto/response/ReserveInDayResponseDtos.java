package com.yscp.catchtable.presentation.reserve.dto.response;

import com.yscp.catchtable.application.reserve.ReservesInDayDto;
import com.yscp.catchtable.application.reserve.dto.ReserveInDayDto;

import java.util.ArrayList;
import java.util.List;

public record ReserveInDayResponseDtos(
        List<ReserveInDayResponseDto> reserves
) {
    public static ReserveInDayResponseDtos from(ReservesInDayDto reservesInDay) {
        if (reservesInDay == null) {
            return new ReserveInDayResponseDtos(new ArrayList<>());
        }

        return new ReserveInDayResponseDtos(convert(reservesInDay.reserves()));
    }

    private static List<ReserveInDayResponseDto> convert(List<ReserveInDayDto> reservesInDay) {
        return reservesInDay.stream()
                .map(reserveInDayDto -> new ReserveInDayResponseDto(
                        reserveInDayDto.idx(),
                        reserveInDayDto.reserveTime(),
                        reserveInDayDto.maxUserCount()
                )).toList();
    }
}
