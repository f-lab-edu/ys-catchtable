package com.yscp.catchtable.application.reserve.dto;

import java.time.LocalDate;

public record ReserveDto(
        LocalDate date,
        Boolean canReserve
) {
    public static ReserveDto from(StoreReserveDto storeReserveDto) {
        return new ReserveDto(storeReserveDto.getDate(),
                storeReserveDto.getReserve() > 0 ? Boolean.TRUE : Boolean.FALSE);
    }
}
