package com.yscp.catchtable.application.queue.dto;

import java.time.Instant;

public record StoreQueueDto(
        Long storeIdx,
        String date,
        String time,
        String userId
) {
    private static final String WAITING_KEY_FORMAT = "store:%s:waiting:%s:%s";

    public String key() {
        return String.format(WAITING_KEY_FORMAT, storeIdx, date, time);
    }

    public String value() {
        return userId.toString();
    }

    public double score() {
        return Instant.now().toEpochMilli();
    }
}
