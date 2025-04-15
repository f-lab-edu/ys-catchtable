package com.yscp.catchtable.domain.store.entity;

import com.yscp.catchtable.domain.store.entity.value.DayType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class StoreBusinessHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Enumerated(EnumType.STRING)
    @Comment("요일 타입")
    private DayType day;

    @JoinColumn(name = "store_idx")
    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("상점")
    private Store store;

    @Comment("점심 영업 시작 시간")
    Integer lunchStartTime;
    @Comment("점심 영업 종료 시간")
    Integer lunchEndTime;
    @Comment("저녁 영업 시작 시간")
    Integer dinerStartTime;
    @Comment("저녁 영업 종료 시간")
    Integer dinerEndTime;
    @Comment("라스트 오더")
    Integer lastOrder;

    public StoreBusinessHour(Long idx, DayType dayType, Store store, Integer lunchStartTime, Integer lunchEndTime, Integer dinerStartTime, Integer dinerEndTime, Integer lastOrder) {
        this.idx = idx;
        this.day = dayType;
        this.store = store;
        this.lunchStartTime = lunchStartTime;
        this.lunchEndTime = lunchEndTime;
        this.dinerStartTime = dinerStartTime;
        this.dinerEndTime = dinerEndTime;
        this.lastOrder = lastOrder;
    }
}
