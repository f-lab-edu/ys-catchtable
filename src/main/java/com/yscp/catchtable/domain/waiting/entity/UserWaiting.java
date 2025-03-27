package com.yscp.catchtable.domain.waiting.entity;


import com.yscp.catchtable.domain.user.entity.value.UserType;
import com.yscp.catchtable.domain.waiting.entity.value.WaitingType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class UserWaiting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @JoinColumn(name = "store_waiting_idx")
    @ManyToOne(fetch = FetchType.LAZY)
    private StoreWaiting storeWaiting;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private String userIdx;

    private LocalDate waitingDate;
    private WaitingType waitingType;
    private LocalDateTime registerTime;
    private LocalDateTime modDatetime;


}
