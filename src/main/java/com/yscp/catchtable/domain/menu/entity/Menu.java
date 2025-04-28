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


    @Comment("메뉴 가격")
    private String price;
    @Comment("메뉴명")
    private String name;
    @Comment("메뉴 이미지")
    private String imageUrl;
    @Comment("메뉴 순서")
    private Integer ord;
    private LocalDateTime regDatetime;
    private Long regIdx;
    private LocalDateTime modDatetime;
    private Long modIdx;
}
