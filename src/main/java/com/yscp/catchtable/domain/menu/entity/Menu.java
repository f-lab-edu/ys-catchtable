package com.yscp.catchtable.domain.menu.entity;

import com.yscp.catchtable.domain.category.entitry.MenuCategory;
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
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @JoinColumn(name = "store_idx")
    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("상점")
    private Store store;

    @JoinColumn(name = "category_idx")
    @OneToOne(fetch = FetchType.LAZY)
    @Comment("상점 메뉴 카테고리")
    private MenuCategory category;


    private String price;
    private String name;
    private String imageUrl;
    private Integer ord;
    private LocalDateTime regDatetime;
    private Long regIdx;
    private LocalDateTime modDatetime;
    private Long modIdx;
}
