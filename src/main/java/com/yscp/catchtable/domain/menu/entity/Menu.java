package com.yscp.catchtable.domain.menu.entity;

import com.yscp.catchtable.domain.category.entitry.Category;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @JoinColumn(name = "category_idx")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    private Integer price;
    private String name;
    private String imageUrl;
    private Integer ord;
    private LocalDateTime regDatetime;
    private Long regIdx;
    private LocalDateTime modDatetime;
    private Long modIdx;
}
