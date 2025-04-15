package com.yscp.catchtable.presentation.store.dto.response;

import com.yscp.catchtable.presentation.common.dto.response.ImageResponse;
import com.yscp.catchtable.presentation.reserve.dto.response.ReserveResponseDto;
import com.yscp.catchtable.presentation.review.dto.response.ReviewResponseDto;

import java.util.List;

public record StoreItemResponseDto(
        String title,
        Boolean canCatchPay,
        Boolean canCatchReserve,
        ReviewResponseDto review,
        String location,
        String type,
        List<ImageResponse> image,
        String businessHour,
        String fee,
        String event,
        List<ReserveResponseDto> reserveList
) {
}
