package com.yscp.catchtable.application.store.dto;

import com.yscp.catchtable.application.reserve.dto.ReserveDto;
import com.yscp.catchtable.application.review.dto.StoreReviewDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class StoreDto {
    private final String title;
    private final Boolean canCatchPay;
    private final Boolean canCatchReserve;
    private final StoreReviewDto review;
    private final String location;
    private final String type;
    private final List<StoreImageDto> image;
    private final String businessHour;
    private final String fee;
    private final String event;
    private final List<ReserveDto> reserveLis;
}
