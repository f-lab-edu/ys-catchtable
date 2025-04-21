package com.yscp.catchtable.application.store.dto;

import com.yscp.catchtable.domain.store.entity.StoreBusinessHour;
import lombok.Getter;

@Getter
public class StoreBusinessDto {
    private final Long idx;
    private final Long storeIdx;
    private final Integer lunchStartTime;
    private final Integer lunchEndTime;
    private final Integer dinerStartTime;
    private final Integer dinerEndTime;

    public static StoreBusinessDto from(StoreBusinessHour storeBusinessHour) {
        return new StoreBusinessDto(storeBusinessHour.getIdx(),
                storeBusinessHour.getStore().getIdx(),
                storeBusinessHour.getLunchStartTime(),
                storeBusinessHour.getLunchEndTime(),
                storeBusinessHour.getDinerStartTime(),
                storeBusinessHour.getDinerEndTime());
    }

    public StoreBusinessDto(Long idx, Long storeIdx, Integer lunchStartTime, Integer lunchEndTime, Integer dinerStartTime, Integer dinerEndTime) {
        this.idx = idx;
        this.storeIdx = storeIdx;
        this.lunchStartTime = lunchStartTime;
        this.lunchEndTime = lunchEndTime;
        this.dinerStartTime = dinerStartTime;
        this.dinerEndTime = dinerEndTime;
    }

    public Integer startTime() {
        return lunchStartTime == null
                ? dinerStartTime
                : lunchStartTime;
    }

    public Integer endTime() {
        return dinerEndTime == null
                ? lunchEndTime
                : dinerEndTime;
    }
}
