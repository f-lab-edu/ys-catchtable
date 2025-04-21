package com.yscp.catchtable.presentation.reserve.dto.response;

import com.yscp.catchtable.application.reserve.dto.ReserveDto;

import java.time.LocalDate;

public record ReserveResponseDto(
        LocalDate date,
        boolean canReserve
) {
    public static ReserveResponseDto from(ReserveDto reserveDto) {
        return new ReserveResponseDto(
                reserveDto.date(),
                reserveDto.canReserve()
        );
    }
}
