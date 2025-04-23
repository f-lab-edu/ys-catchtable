package com.yscp.catchtable.domain.store.entity;

import com.yscp.catchtable.domain.store.entity.value.DayType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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
    String lunchStartTime;
    @Comment("점심 영업 종료 시간")
    String lunchEndTime;
    @Comment("저녁 영업 시작 시간")
    String dinerStartTime;
    @Comment("저녁 영업 종료 시간")
    String dinerEndTime;
    @Comment("라스트 오더")
    String lastOrder;

    @Builder
    public StoreBusinessHour(Long idx, DayType day, Store store, String lunchStartTime, String lunchEndTime, String dinerStartTime, String dinerEndTime, String lastOrder) {
        this.idx = idx;
        this.day = day;
        this.store = store;
        this.lunchStartTime = lunchStartTime;
        this.lunchEndTime = lunchEndTime;
        this.dinerStartTime = dinerStartTime;
        this.dinerEndTime = dinerEndTime;
        this.lastOrder = lastOrder;
    }
}
