package com.yscp.catchtable.presentation.review.dto.response;

import lombok.Getter;

public record ReviewResponseDto(
        String score,
        Integer participantCount
) {
}
