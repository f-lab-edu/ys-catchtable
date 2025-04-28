package com.yscp.catchtable.presentation.businesshour.dto.response;

import com.yscp.catchtable.application.store.dto.StoreBusinessDto;

public record StoreBusinessResponseDto(
        String day,
        String launchStartTime,
        String launchEndTime,
        String dinerStartTime,
        String dinerEndTime
) {
    public static StoreBusinessResponseDto from(StoreBusinessDto storeBusinessDto) {
        return new StoreBusinessResponseDto(storeBusinessDto.getDayType().name(),
                storeBusinessDto.getLunchStartTime(),
                storeBusinessDto.getLunchEndTime(),
                storeBusinessDto.getDinerStartTime(),
                storeBusinessDto.getDinerEndTime());
    }
}
