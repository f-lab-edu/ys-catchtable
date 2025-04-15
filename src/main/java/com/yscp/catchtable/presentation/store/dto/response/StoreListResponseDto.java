package com.yscp.catchtable.presentation.store.dto.response;

import lombok.Getter;

import java.util.List;

public record StoreListResponseDto(
        List<StoreItemResponseDto> data
) {
}
