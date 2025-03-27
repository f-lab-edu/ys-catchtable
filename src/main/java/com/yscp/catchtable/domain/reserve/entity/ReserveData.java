package com.yscp.catchtable.domain.reserve.entity;

import com.yscp.catchtable.domain.reserve.entity.value.StoreReserveDataStatus;
import com.yscp.catchtable.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @JoinColumn(name = "store_idx")
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    private LocalDate reserveData;
    private Integer reserveTime;
    private Integer minUserCount;
    private Integer maxUserCount;
    private Integer reserveCount;
    @Enumerated(EnumType.STRING)
    private StoreReserveDataStatus reserveStatus;
    private LocalDateTime regDatetime;
    private Long regIdx;
    private LocalDateTime modDatetime;
    private Long modIdx;
}
