package com.yscp.catchtable.presentation.store.dto.response;

import com.yscp.catchtable.application.store.dto.StoreListDto;

import java.util.List;

public record StoreListResponseDto(
        List<StoreItemResponseDto> data
) {
    public static StoreListResponseDto from(StoreListDto storeListDto) {
        List<StoreItemResponseDto> itemResponseDtos = storeListDto.getList()
                .stream()
                .map(StoreItemResponseDto::from)
                .toList();
        return new StoreListResponseDto(itemResponseDtos);
    }
}
