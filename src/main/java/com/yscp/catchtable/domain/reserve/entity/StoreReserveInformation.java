package com.yscp.catchtable.domain.reserve.entity;

import com.yscp.catchtable.domain.reserve.entity.value.StoreReserveInformationType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class StoreReserveInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private Integer reservePrice;

    @Enumerated(EnumType.STRING)
    private StoreReserveInformationType reserveType;

    private Integer minUserCount;

    private LocalDateTime regDatetime;
    private Long regIdx;
    private LocalDateTime modDatetime;
    private Long modIdx;
}
