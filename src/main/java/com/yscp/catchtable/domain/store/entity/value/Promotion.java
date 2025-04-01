package com.yscp.catchtable.domain.store.entity.value;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@Getter
public class Promotion {

    @Comment("상점 활성화 여부")
    private Boolean hasPromotion;

    @Comment("상점 프로모션 이미지")
    private String promotionImage;

    @Column(name = "promotion_start_date")
    @Comment("상점 프로모션 시작 시간")
    private LocalDateTime startDate;

    @Column(name = "promotion_end_date")
    @Comment("상점 프로모션 종료 시간")
    private LocalDateTime promotionEndDate;


    public Promotion(Boolean hasPromotion, String promotionImage, LocalDateTime startDate, LocalDateTime promotionEndDate) {
        this.hasPromotion = hasPromotion;
        this.promotionImage = promotionImage;
        this.startDate = startDate;
        this.promotionEndDate = promotionEndDate;
    }
}
