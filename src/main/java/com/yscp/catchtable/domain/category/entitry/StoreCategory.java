package com.yscp.catchtable.domain.category.entitry;


import com.yscp.catchtable.domain.category.entitry.value.StoreCategoryCode;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class StoreCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Enumerated(EnumType.STRING)
    private StoreCategoryCode code;

    @Column(nullable = false)
    private String name;

    private LocalDateTime regDatetime;

    private LocalDateTime modDatetime;

    @Builder
    public StoreCategory(Long idx, StoreCategoryCode code, String name, LocalDateTime regDatetime, LocalDateTime modDatetime) {
        this.idx = idx;
        this.code = code;
        this.name = name;
        this.regDatetime = regDatetime;
        this.modDatetime = modDatetime;
    }
}
