package com.yscp.catchtable.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum BadRequestError implements CustomError {

    /**
     * 0 ~ 100 Common
     */
    NULL_EXCEPTION("%s", "1", true),
    INVALID_RESERVE_PAY_TYPE("지불 방식이 잘못됐습니다.", "2", false),

    /**
     * 101 ~ 200 예약
     */
    EXPIRED_TICKET("예약 가능 시간을 초과하였습니다. \n 다시 예약 요청을 진행 해주세요.", "101", false),
    STORE_RESERVATION_MAX("모든 예약이 완료된 상태입니다. \n 다음에 이용해주세요.", "102", false);

    private final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    private final String message;
    private final String errorCode;
    private final Boolean isCustomMessage;

    @Override
    public Boolean isCustomMessage() {
        return isCustomMessage;
    }
}
