package com.yscp.catchtable.presentation.store.dto;

public record StoreQueueRequestDto(
        Long storeIdx,
        String date,
        String time,
        String userId
) {
}
