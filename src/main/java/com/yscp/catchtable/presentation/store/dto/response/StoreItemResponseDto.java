package com.yscp.catchtable.presentation.store.dto.response;

import com.yscp.catchtable.application.store.dto.StoreDto;
import com.yscp.catchtable.presentation.reserve.dto.response.ReserveResponseDto;

import java.util.List;

public record StoreItemResponseDto(
        Long idx,
        String title,
        String location,
        String type,
        String startTime,
        String endTime,
        String fee,
        List<ReserveResponseDto> reserveList
) {
    public static StoreItemResponseDto from(StoreDto storeDto) {
        List<ReserveResponseDto> reserveResponseDtos = storeDto.getReserveList()
                .stream()
                .map(ReserveResponseDto::from)
                .toList();

        return new StoreItemResponseDto(
                storeDto.getIdx(),
                storeDto.getTitle(),
                storeDto.getLocation(),
                storeDto.getType(),
                storeDto.getStartTime(),
                storeDto.getEndTime(),
                storeDto.getFee(),
                reserveResponseDtos);
    }
}
