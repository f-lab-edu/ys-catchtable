package com.yscp.catchtable.application.store.mapper;

import com.yscp.catchtable.application.queue.dto.StoreQueueDto;
import com.yscp.catchtable.presentation.store.dto.StoreQueueRequestDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StoreQueueMapper {
    public static StoreQueueDto toQueueDto(StoreQueueRequestDto storeQueueRequestDto) {
        return new StoreQueueDto(
                storeQueueRequestDto.storeIdx(),
                storeQueueRequestDto.date(),
                storeQueueRequestDto.time(),
                storeQueueRequestDto.userId()
        );
    }
}
