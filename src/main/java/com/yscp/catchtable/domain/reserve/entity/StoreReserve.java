package com.yscp.catchtable.domain.reserve.entity;

import com.yscp.catchtable.domain.reserve.entity.value.StoreReserveStatus;
import com.yscp.catchtable.domain.store.entity.Store;
import com.yscp.catchtable.exception.BadRequestError;
import com.yscp.catchtable.exception.CatchTableException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "store_reserve")
public class StoreReserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Comment("상점")
    @JoinColumn(name = "store_idx")
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    @Comment("예약 일자")
    private LocalDate reserveDate;
    @Comment("예약 시간")
    private String reserveTime;
    @Comment("최소 인원")
    private Integer minUserCount;
    @Comment("최대 인원")
    private Integer maxUserCount;
    @Comment("예약 가능 횟수")
    private Integer canReserveCount;
    @Comment("예약된 횟수")
    private Integer reservedCount;
    @Enumerated(EnumType.STRING)
    private StoreReserveStatus reserveStatus;
    private LocalDateTime regDatetime;
    private Long regIdx;
    private LocalDateTime modDatetime;
    private Long modIdx;

    @Builder
    public StoreReserve(Long idx,
                        Store store,
                        LocalDate reserveDate,
                        String reserveTime,
                        Integer minUserCount,
                        Integer maxUserCount,
                        Integer canReserveCount,
                        Integer reservedCount,
                        StoreReserveStatus reserveStatus,
                        LocalDateTime regDatetime,
                        Long regIdx,
                        LocalDateTime modDatetime,
                        Long modIdx) {
        this.idx = idx;
        this.store = store;
        this.reserveDate = reserveDate;
        this.reserveTime = reserveTime;
        this.minUserCount = minUserCount;
        this.maxUserCount = maxUserCount;
        this.canReserveCount = canReserveCount;
        this.reservedCount = reservedCount;
        this.reserveStatus = reserveStatus;
        this.regDatetime = regDatetime;
        this.regIdx = regIdx;
        this.modDatetime = modDatetime;
        this.modIdx = modIdx;
    }

    public void userReserve(LocalDateTime userReserveDatetime, Long userIdx) {
        if (reservedCount >= canReserveCount) {
            throw new CatchTableException(BadRequestError.STORE_RESERVATION_MAX);
        }

        reservedCount += 1;
        modDatetime = userReserveDatetime;
        modIdx = userIdx;
    }
}
