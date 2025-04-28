package com.yscp.catchtable.application.amenity.dto;

import com.yscp.catchtable.domain.amenity.entity.StoreAmenity;

public record StoreAmenityDto(
        String code,
        String memo,
        String image
) {

    public static StoreAmenityDto from(StoreAmenity amenity) {
        return new StoreAmenityDto(amenity.getAmenity().getCode(),
                amenity.getMemo(),
                amenity.getAmenity().getImageUrl());
    }
}
