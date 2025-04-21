package com.yscp.catchtable.domain.reserve.entity;

import com.yscp.catchtable.domain.reserve.entity.value.StoreReserveDataStatus;
import com.yscp.catchtable.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "store_reserve_data")
public class ReserveData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Comment("상점")
    @JoinColumn(name = "store_idx")
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    @Comment("예약 일자")
    private LocalDate reserveData;
    @Comment("예약 시간")
    private Integer reserveTime;
    @Comment("최소 인원")
    private Integer minUserCount;
    @Comment("최대 인원")
    private Integer maxUserCount;
    @Comment("예약 가능 횟수")
    private Integer canReserveCount;
    @Comment("예약된 횟수")
    private Integer reservedCount;
    @Enumerated(EnumType.STRING)
    private StoreReserveDataStatus reserveStatus;
    private LocalDateTime regDatetime;
    private Long regIdx;
    private LocalDateTime modDatetime;
    private Long modIdx;
}
