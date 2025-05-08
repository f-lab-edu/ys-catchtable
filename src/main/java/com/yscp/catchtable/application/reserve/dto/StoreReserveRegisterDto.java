package com.yscp.catchtable.application.reserve.dto;

import java.time.LocalDateTime;

public record StoreReserveRegisterDto(
        Long userIdx,
        Long storeReserveIdx,
        String reservePayType,
        String transactionNo,
        String purpose,
        Integer reservationNumberOfPeople,
        LocalDateTime requestDatetime
) {
}
