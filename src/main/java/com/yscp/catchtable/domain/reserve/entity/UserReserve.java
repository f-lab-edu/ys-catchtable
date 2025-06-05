package com.yscp.catchtable.domain.reserve.entity;

import com.yscp.catchtable.domain.reserve.entity.value.ReservePayType;
import com.yscp.catchtable.domain.reserve.entity.value.ReserveStatus;
import com.yscp.catchtable.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class UserReserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @JoinColumn(name = "user_idx")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "store_reserve_idx")
    @ManyToOne(fetch = FetchType.LAZY)
    private StoreReserve storeReserve;

    @Enumerated(EnumType.STRING)
    private ReserveStatus reserveStatus;
    @Enumerated(EnumType.STRING)
    private ReservePayType reservePayType;
    private LocalDateTime regDatetime;
    private Long regIdx;
    private LocalDateTime modDatetime;
    private Long modIdx;

    @Builder
    public UserReserve(Long idx,
                       User user,
                       StoreReserve storeReserve,
                       ReserveStatus reserveStatus,
                       ReservePayType reservePayType,
                       LocalDateTime regDatetime,
                       Long regIdx,
                       LocalDateTime modDatetime,
                       Long modIdx) {
        this.idx = idx;
        this.user = user;
        this.storeReserve = storeReserve;
        this.reserveStatus = reserveStatus;
        this.reservePayType = reservePayType;
        this.regDatetime = regDatetime;
        this.regIdx = regIdx;
        this.modDatetime = modDatetime;
        this.modIdx = modIdx;
    }
}
