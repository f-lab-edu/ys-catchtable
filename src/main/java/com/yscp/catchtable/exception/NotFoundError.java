package com.yscp.catchtable.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum NotFoundError implements CustomError {
    NOT_FOUND_STORE("상점을 찾을 수 없습니다.", 100, false),
    NOT_FOUND_BUSINESS_HOUR("영업 시간을 조회할 수 없습니다.", 101, false);

    private final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    private final String message;
    private final Integer errorCode;
    private final Boolean isCustomMessage;

    @Override
    public String getErrorCode() {
        return "NOT_FOUND_" + errorCode;
    }

    @Override
    public Boolean isCustomMessage() {
        return isCustomMessage;
    }
}
