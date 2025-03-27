package com.yscp.catchtable.domain.store.entity.value;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@Getter
public class Promotion {

    private Boolean hasPromotion;
    private String promotionImage;
    @Column(name = "promotion_start_date")
    private LocalDateTime startDate;
    @Column(name = "promotion_end_date")
    private LocalDateTime promotionEndDate;


    public Promotion(Boolean hasPromotion, String promotionImage, LocalDateTime startDate, LocalDateTime promotionEndDate) {
        this.hasPromotion = hasPromotion;
        this.promotionImage = promotionImage;
        this.startDate = startDate;
        this.promotionEndDate = promotionEndDate;
    }
}
