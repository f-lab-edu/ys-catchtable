package com.yscp.catchtable.application.queue.dto;

import java.time.Instant;

public record StoreQueueDto(
        String storeReserveIdx,
        String userIdx
) {
    private static final String WAITING_KEY_FORMAT = "store:%s:waiting:%s";
    private static final String RESERVE_KEY_FORMAT = "store:%s:reserve:%s";

    public String key() {
        return String.format(WAITING_KEY_FORMAT, storeReserveIdx, userIdx);
    }

    public String value() {
        return userIdx;
    }

    public double score() {
        return Instant.now().toEpochMilli();
    }

    public String reserveKey() {
        return String.format(RESERVE_KEY_FORMAT, storeReserveIdx, userIdx);
    }
}
