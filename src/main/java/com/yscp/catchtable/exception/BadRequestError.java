package com.yscp.catchtable.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum BadRequestError implements CustomError {
    ;

    private final String message;
    private final Integer errorCode;
    private final Boolean isCustomMessage;

    @Override
    public HttpStatus statusCode() {
        return HttpStatus.BAD_REQUEST;
    }

    @Override
    public String errorCode() {
        return "BAD_REQUEST_" + errorCode;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public Boolean isCustomMessage() {
        return isCustomMessage;
    }
}
