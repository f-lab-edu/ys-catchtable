package com.yscp.catchtable.application.location.dto;

import org.locationtech.jts.geom.Point;

public record LocationDto(
        String addressCode,
        String name,
        double xCoordinate,
        double yCoordinate
) {
    public LocationDto(String addressCode, String name, Point point) {
        this(addressCode, name, point.getX(), point.getY());
    }
}
