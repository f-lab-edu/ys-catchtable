package com.yscp.catchtable.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum NotFoundError implements CustomError {
    NOT_FOUND_STORE("상점을 찾을 수 없습니다.", "100", false),
    NOT_FOUND_BUSINESS_HOUR("영업 시간을 조회할 수 없습니다.", "101", false);

    private final HttpStatus httpStatus = HttpStatus.NOT_FOUND;
    private final String message;
    private final String errorCode;
    private final Boolean isCustomMessage;

    @Override
    public Boolean isCustomMessage() {
        return isCustomMessage;
    }
}
