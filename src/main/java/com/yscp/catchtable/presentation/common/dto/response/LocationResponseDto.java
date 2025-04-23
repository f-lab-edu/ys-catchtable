package com.yscp.catchtable.presentation.common.dto.response;

import com.yscp.catchtable.application.location.dto.LocationDto;

public record LocationResponseDto(
        String addressCode,
        String name,
        double xCoordinate,
        double yCoordinate
) {

    public LocationResponseDto(LocationDto locationDto) {
        this(locationDto.addressCode(),
                locationDto.name(),
                locationDto.xCoordinate(),
                locationDto.yCoordinate());
    }
}
