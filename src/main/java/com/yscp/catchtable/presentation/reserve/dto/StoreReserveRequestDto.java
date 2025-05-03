package com.yscp.catchtable.presentation.reserve.dto;

public record StoreReserveRequestDto(
        Long userIdx,
        Long storeReserveIdx,
        String reserveType,
        String transactionNo,
        String purpose,
        Integer reservationNumberOfPeople
) {
}
