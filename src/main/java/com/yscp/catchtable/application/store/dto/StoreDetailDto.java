package com.yscp.catchtable.application.store.dto;

import com.yscp.catchtable.application.amenity.dto.StoreAmenityDto;
import com.yscp.catchtable.application.location.dto.LocationDto;
import com.yscp.catchtable.application.menu.dto.MenuDto;
import com.yscp.catchtable.application.reserve.dto.ReserveDto;

import java.util.List;

public record StoreDetailDto(
        Long idx,
        String categoryName,
        String tel,
        String introduce,
        String price,
        LocationDto location,
        List<ReserveDto> reserveList,
        List<MenuDto> menuList,
        List<StoreAmenityDto> amenities,
        List<StoreBusinessDto> businessHour
) {
}
