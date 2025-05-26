package com.yscp.catchtable.application.reserve.mapper;

import com.yscp.catchtable.application.reserve.dto.StoreReserveRegisterDto;
import com.yscp.catchtable.domain.reserve.entity.StoreReserve;
import com.yscp.catchtable.domain.reserve.entity.UserReserve;
import com.yscp.catchtable.domain.reserve.entity.value.ReservePayType;
import com.yscp.catchtable.domain.reserve.entity.value.ReserveStatus;
import com.yscp.catchtable.domain.user.entity.User;

public class UserReserveDataMapper {
    public static UserReserve toEntity(StoreReserve reserveData, StoreReserveRegisterDto dto) {
        User requestUser = User.builder()
                .idx(dto.userIdx())
                .build();

        return UserReserve.builder()
                .user(requestUser)
                .storeReserve(reserveData)
                .reserveStatus(ReserveStatus.RESERVE)
                .reservePayType(ReservePayType.from(dto.reservePayType()))
                .regIdx(dto.userIdx())
                .regDatetime(dto.requestDatetime())
                .build();
    }
}
