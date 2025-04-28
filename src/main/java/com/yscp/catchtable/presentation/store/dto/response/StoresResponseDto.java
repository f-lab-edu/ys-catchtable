package com.yscp.catchtable.presentation.store.dto.response;

import com.yscp.catchtable.application.store.dto.StoreDtos;

import java.util.List;

public record StoresResponseDto(
        List<StoreItemResponseDto> data
) {
    public static StoresResponseDto from(StoreDtos storeDtos) {
        List<StoreItemResponseDto> itemResponseDtos = storeDtos.getList()
                .stream()
                .map(StoreItemResponseDto::from)
                .toList();
        return new StoresResponseDto(itemResponseDtos);
    }
}
