package com.yscp.catchtable.presentation.reserve.dto.response;

import java.time.LocalDate;

public record ReserveResponseDto(
        LocalDate date,
        boolean canReserve
) {
}
