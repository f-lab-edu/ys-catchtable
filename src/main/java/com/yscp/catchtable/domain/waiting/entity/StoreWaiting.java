package com.yscp.catchtable.domain.waiting.entity;

import com.yscp.catchtable.domain.store.entity.Store;
import com.yscp.catchtable.domain.waiting.entity.value.StoreWaitingStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class StoreWaiting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @JoinColumn(name = "store_idx")
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    @Enumerated(EnumType.STRING)
    private StoreWaitingStatus status;

    private LocalDateTime regDatetime;
    private Long regIdx;
    private LocalDateTime modDatetime;
    private Long modIdx;
}
