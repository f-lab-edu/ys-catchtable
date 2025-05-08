package com.yscp.catchtable.application.reserve.mapper;

import com.yscp.catchtable.application.reserve.dto.StoreReserveRegisterDto;
import com.yscp.catchtable.domain.reserve.entity.ReserveData;
import com.yscp.catchtable.domain.reserve.entity.UserReserveData;
import com.yscp.catchtable.domain.reserve.entity.value.ReservePayType;
import com.yscp.catchtable.domain.reserve.entity.value.ReserveStatus;
import com.yscp.catchtable.domain.user.entity.User;

public class UserReserveDataMapper {
    public static UserReserveData toEntity(ReserveData reserveData, StoreReserveRegisterDto dto) {
        User requestUser = User.builder()
                .idx(dto.userIdx())
                .build();

        return UserReserveData.builder()
                .user(requestUser)
                .reserveData(reserveData)
                .reserveStatus(ReserveStatus.RESERVE)
                .reservePayType(ReservePayType.from(dto.reservePayType()))
                .regIdx(dto.userIdx())
                .regDatetime(dto.requestDatetime())
                .build();
    }
}
