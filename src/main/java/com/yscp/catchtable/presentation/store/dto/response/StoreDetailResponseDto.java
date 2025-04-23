package com.yscp.catchtable.presentation.store.dto.response;

import com.yscp.catchtable.application.amenity.dto.StoreAmenityDto;
import com.yscp.catchtable.application.menu.dto.MenuDto;
import com.yscp.catchtable.application.reserve.dto.ReserveDto;
import com.yscp.catchtable.application.store.dto.StoreBusinessDto;
import com.yscp.catchtable.application.store.dto.StoreDetailDto;
import com.yscp.catchtable.presentation.ammenity.dto.response.StoreAmenityResponseDto;
import com.yscp.catchtable.presentation.businesshour.dto.response.StoreBusinessResponseDto;
import com.yscp.catchtable.presentation.common.dto.response.LocationResponseDto;
import com.yscp.catchtable.presentation.menu.dto.response.MenuResponseDto;
import com.yscp.catchtable.presentation.reserve.dto.response.ReserveResponseDto;

import java.util.List;

public record StoreDetailResponseDto(
        Long idx,
        String categoryName,
        String tel,
        String introduce,
        String price,
        LocationResponseDto location,
        List<ReserveResponseDto> reserveList,
        List<MenuResponseDto> menuList,
        List<StoreAmenityResponseDto> amenities,
        List<StoreBusinessResponseDto> businessHour

) {
    public static StoreDetailResponseDto from(StoreDetailDto storeDetailDto) {
        LocationResponseDto locationResponseDto = new LocationResponseDto(storeDetailDto.location());
        List<ReserveResponseDto> reserveResponseDtos = convertReserveList(storeDetailDto.reserveList());
        List<MenuResponseDto> menuResponseDtos = convertMenuResponseList(storeDetailDto.menuList());
        List<StoreAmenityResponseDto> amenityResponseDtos = convertAmenitiesResponse(storeDetailDto.amenities());
        List<StoreBusinessResponseDto> businessResponseDtos = convertBusinessResponse(storeDetailDto.businessHour());

        return new StoreDetailResponseDto(
                storeDetailDto.idx(),
                storeDetailDto.categoryName(),
                storeDetailDto.tel(),
                storeDetailDto.introduce(),
                storeDetailDto.price(),
                locationResponseDto, reserveResponseDtos,
                menuResponseDtos,
                amenityResponseDtos,
                businessResponseDtos
        );
    }

    private static List<StoreBusinessResponseDto> convertBusinessResponse(List<StoreBusinessDto> storeBusinessDtos) {
        return storeBusinessDtos.stream()
                .map(StoreBusinessResponseDto::from)
                .toList();
    }


    private static List<MenuResponseDto> convertMenuResponseList(List<MenuDto> menuDtos) {
        return menuDtos.stream()
                .map(MenuResponseDto::from)
                .toList();
    }

    private static List<ReserveResponseDto> convertReserveList(List<ReserveDto> storeReserveDtos) {
        return storeReserveDtos.stream()
                .map(ReserveResponseDto::from)
                .toList();
    }

    private static List<StoreAmenityResponseDto> convertAmenitiesResponse(List<StoreAmenityDto> amenities) {
        return amenities.stream()
                .map(StoreAmenityResponseDto::from)
                .toList();

    }
}
