package com.yscp.catchtable.domain.store.entity;

import com.yscp.catchtable.domain.category.entitry.StoreCategory;
import com.yscp.catchtable.domain.store.entity.value.Promotion;
import com.yscp.catchtable.domain.store.entity.value.convert.DotListConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.geolatte.geom.Point;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Convert(converter = DotListConverter.class)
    @Comment("휴무일")
    private List<String> holiday;

    @Comment("상점명")
    @Column(nullable = false)
    private String name;

    @Comment("가게 유형")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_idx")
    private StoreCategory category;

    @Column(nullable = false, columnDefinition = "GEOMETRY")
    @Comment("상점 좌표")
    private Point point;

    @Column(nullable = false)
    @Comment("상점 안내")
    private String introduce;

    @Column(nullable = false)
    @Comment("상점 길안내")
    private String directions;

    @Comment("상점 주차 안내")
    private String parkingInformation;

    @Comment("상점 주류 안내")
    private String alcoholInformation;

    @Comment("상점 가격 안내")
    private String feeInformation;

    @Embedded
    @Comment("상점 프로모션 정보")
    private Promotion promotion;

    @Comment("행정동 코드")
    private String addressCode;

    @Comment("상점 지역")
    private String locationName;

    @Comment("상점 등록일시")
    private LocalDateTime regDatetime;

    @Comment("상점 등록자 식별자 번호")
    private Long regIdx;

    @Comment("상점 수정일시")
    private LocalDateTime modDatetime;

    @Comment("상점 수정자 식별자 번호")
    private Long modIdx;

    @Builder
    public Store(Long idx, List<String> holiday, String name, StoreCategory category, Point point, String introduce, String directions, String parkingInformation, String alcoholInformation, String feeInformation, Promotion promotion, String addressCode, String locationName, LocalDateTime regDatetime, Long regIdx, LocalDateTime modDatetime, Long modIdx) {
        this.idx = idx;
        this.holiday = holiday;
        this.name = name;
        this.category = category;
        this.point = point;
        this.introduce = introduce;
        this.directions = directions;
        this.parkingInformation = parkingInformation;
        this.alcoholInformation = alcoholInformation;
        this.feeInformation = feeInformation;
        this.promotion = promotion;
        this.addressCode = addressCode;
        this.locationName = locationName;
        this.regDatetime = regDatetime;
        this.regIdx = regIdx;
        this.modDatetime = modDatetime;
        this.modIdx = modIdx;
    }
}
