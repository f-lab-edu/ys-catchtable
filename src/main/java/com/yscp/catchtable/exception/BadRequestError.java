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

    /**
     * 200 ~ 300 Waiting
     */
    ALREADY_REGISTER_WAITING("이미 예약을 진행하고 있습니다.", "200" , false);

    private final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    private final String message;
    private final String errorCode;
    private final Boolean isCustomMessage;

    @Override
    public Boolean isCustomMessage() {
        return isCustomMessage;
    }
}
