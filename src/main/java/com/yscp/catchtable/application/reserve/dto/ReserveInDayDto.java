package com.yscp.catchtable.application.reserve.dto;

public record ReserveInDayDto(
        Long idx,
        String reserveTime,
        Integer maxUserCount
) {
}
