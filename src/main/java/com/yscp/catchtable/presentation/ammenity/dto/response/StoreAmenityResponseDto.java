package com.yscp.catchtable.presentation.ammenity.dto.response;

import com.yscp.catchtable.application.amenity.dto.StoreAmenityDto;

public record StoreAmenityResponseDto(
        String code,
        String memo,
        String image
) {
    public static StoreAmenityResponseDto from(StoreAmenityDto storeAmenityDto) {
        return new StoreAmenityResponseDto(
                storeAmenityDto.code(),
                storeAmenityDto.memo(),
                storeAmenityDto.image()
        );
    }
}
