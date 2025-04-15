package com.yscp.catchtable.domain.category.entitry;


import com.yscp.catchtable.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "menu_category")
public class MenuCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @JoinColumn(name = "store_idx")
    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("상점")
    private Store store;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer ord;

    private LocalDateTime regDatetime;

    private Long regIdx;

    private LocalDateTime modDatetime;

    private Long modIdx;

    public MenuCategory(Long idx, Store store, String name, Integer ord, LocalDateTime regDatetime, Long regIdx, LocalDateTime modDatetime, Long modIdx) {
        this.idx = idx;
        this.store = store;
        this.name = name;
        this.ord = ord;
        this.regDatetime = regDatetime;
        this.regIdx = regIdx;
        this.modDatetime = modDatetime;
        this.modIdx = modIdx;
    }
}
