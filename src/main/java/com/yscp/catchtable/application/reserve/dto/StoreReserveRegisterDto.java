package com.yscp.catchtable.application.reserve.dto;

public record StoreReserveRegisterDto(
        Long userIdx,
        Long storeReserveIdx,
        String reserveType,
        String transactionNo,
        String purpose,
        Integer reservationNumberOfPeople
) {
}
