package com.yscp.catchtable.domain.reserve.entity.value;

import com.yscp.catchtable.exception.BadRequestError;
import com.yscp.catchtable.exception.CatchTableException;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum ReservePayType {
    CARD,
    CATCH_PAY;

    private static final Map<String, ReservePayType> MAPPING;

    static {
        MAPPING = Arrays.stream(ReservePayType.values())
                .collect(Collectors.toMap(Enum::name, e -> e));
    }

    public static ReservePayType from(String reserveTypeString) {
        if (reserveTypeString == null || reserveTypeString.isEmpty()) {
            throw new CatchTableException(BadRequestError.INVALID_RESERVE_PAY_TYPE);
        }
        return MAPPING.get(reserveTypeString.toUpperCase());
    }
}
