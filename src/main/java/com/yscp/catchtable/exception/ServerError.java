package com.yscp.catchtable.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ServerError implements CustomError {

    /**
     * 0 ~ 100 Common
     */
    SERVER_ERROR("캐치테이블 서버에 에러가 발생했습니다.", "1", true),
    ;
    private final HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    private final String message;
    private final String errorCode;
    private final Boolean isCustomMessage;

    @Override
    public Boolean isCustomMessage() {
        return isCustomMessage;
    }
}
