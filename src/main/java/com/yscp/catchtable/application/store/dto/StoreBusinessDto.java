package com.yscp.catchtable.application.store.dto;

import com.yscp.catchtable.domain.store.entity.StoreBusinessHour;
import com.yscp.catchtable.domain.store.entity.value.DayType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class StoreBusinessDto {
    private final Long idx;
    private final Long storeIdx;
    private final DayType dayType;
    private final String lunchStartTime;
    private final String lunchEndTime;
    private final String dinerStartTime;
    private final String dinerEndTime;

    public static StoreBusinessDto from(StoreBusinessHour storeBusinessHour) {
        return new StoreBusinessDto(storeBusinessHour.getIdx(),
                storeBusinessHour.getStore().getIdx(),
                storeBusinessHour.getDay(),
                storeBusinessHour.getLunchStartTime(),
                storeBusinessHour.getLunchEndTime(),
                storeBusinessHour.getDinerStartTime(),
                storeBusinessHour.getDinerEndTime());
    }

    @Builder
    public StoreBusinessDto(Long idx, Long storeIdx, DayType dayType, String lunchStartTime, String lunchEndTime, String dinerStartTime, String dinerEndTime) {
        this.idx = idx;
        this.storeIdx = storeIdx;
        this.dayType = dayType;
        this.lunchStartTime = lunchStartTime;
        this.lunchEndTime = lunchEndTime;
        this.dinerStartTime = dinerStartTime;
        this.dinerEndTime = dinerEndTime;
    }

    public String startTime() {
        return lunchStartTime == null
                ? dinerStartTime
                : lunchStartTime;
    }

    public String endTime() {
        return dinerEndTime == null
                ? lunchEndTime
                : dinerEndTime;
    }
}
