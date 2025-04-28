package com.yscp.catchtable.application.review.dto;

import lombok.Getter;

@Getter
public class StoreReviewDto {
    private Long storeIdx;
    private Double score;
    private Integer participant;

    public StoreReviewDto(Long storeIdx, Double score, Integer participant) {
        this.storeIdx = storeIdx;
        this.score = score;
        this.participant = participant;
    }
}
