package com.yscp.catchtable.application.reserve;

import com.yscp.catchtable.application.reserve.dto.ReserveInDayDto;
import com.yscp.catchtable.domain.reserve.entity.StoreReserve;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public record ReservesInDayDto(
        List<ReserveInDayDto> reserves
) {
    public static ReservesInDayDto from(List<StoreReserve> reserveDates) {
        if (CollectionUtils.isEmpty(reserveDates)) {
            return new ReservesInDayDto(new ArrayList<>());
        }

        return new ReservesInDayDto(convert(reserveDates));
    }

    private static List<ReserveInDayDto> convert(List<StoreReserve> reserveDates) {
        return reserveDates.stream()
                .map(reserveData -> new ReserveInDayDto(
                        reserveData.getIdx(),
                        reserveData.getReserveTime(),
                        reserveData.getMaxUserCount()
                )).toList();
    }
}
