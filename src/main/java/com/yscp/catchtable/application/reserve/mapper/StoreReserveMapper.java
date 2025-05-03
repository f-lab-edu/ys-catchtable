package com.yscp.catchtable.application.reserve.mapper;

import com.yscp.catchtable.application.reserve.dto.StoreReserveRegisterDto;
import com.yscp.catchtable.presentation.reserve.dto.StoreReserveRequestDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StoreReserveMapper {
    public static StoreReserveRegisterDto toDto(StoreReserveRequestDto storeReserveRequestDto) {
        return new StoreReserveRegisterDto(
                storeReserveRequestDto.userIdx(),
                storeReserveRequestDto.storeReserveIdx(),
                storeReserveRequestDto.reserveType(),
                storeReserveRequestDto.transactionNo(),
                storeReserveRequestDto.purpose(),
                storeReserveRequestDto.reservationNumberOfPeople()
        );
    }
}
