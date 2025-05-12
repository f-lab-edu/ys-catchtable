package com.yscp.catchtable.presentation.reserve.dto.response;

public record ReserveInDayResponseDto(
        Long idx,
        String reserveTime,
        Integer maxUserCount
) {
}
