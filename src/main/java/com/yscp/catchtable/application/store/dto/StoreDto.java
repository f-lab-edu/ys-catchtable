package com.yscp.catchtable.application.store.dto;

import com.yscp.catchtable.application.reserve.dto.ReserveDto;
import com.yscp.catchtable.application.reserve.dto.StoreReserveDto;
import com.yscp.catchtable.domain.store.entity.Store;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class StoreDto {
    private final Long idx;
    private final String title;
    private final String location;
    private final String type;
    private final String startTime;
    private final String endTime;
    private final String fee;
    private final List<ReserveDto> reserveList;

    public static StoreDto of(Store store, List<StoreReserveDto> reserveDtoList, StoreBusinessDto businessHour) {
        List<ReserveDto> reserveDtos = reserveDtoList.stream()
                .map(ReserveDto::from)
                .toList();

        return StoreDto.builder()
                .idx(store.getIdx())
                .title(store.getName())
                .location(store.getLocationName())
                .type(store.getCategory().getName())
                .startTime(businessHour.startTime())
                .endTime(businessHour.endTime())
                .fee(store.getFeeInformation())
                .reserveList(reserveDtos)
                .build();
    }

    @Builder
    public StoreDto(Long idx, String title, String location, String type, String startTime, String endTime, String fee, List<ReserveDto> reserveList) {
        this.idx = idx;
        this.title = title;
        this.location = location;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.fee = fee;
        this.reserveList = reserveList;
    }
}
