package com.yscp.catchtable.domain.category.entitry;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer ord;

    private LocalDateTime regDatetime;

    private Long regIdx;

    private LocalDateTime modDatetime;

    private Long modIdx;

    public Category(Long idx, String name, Integer ord, LocalDateTime regDatetime, Long regIdx, LocalDateTime modDatetime, Long modIdx) {
        this.idx = idx;
        this.name = name;
        this.ord = ord;
        this.regDatetime = regDatetime;
        this.regIdx = regIdx;
        this.modDatetime = modDatetime;
        this.modIdx = modIdx;
    }
}
