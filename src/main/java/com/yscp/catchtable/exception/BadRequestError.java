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
    NULL_EXCEPTION("%s", 1, true);

    private final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    private final String message;
    private final Integer errorCode;
    private final Boolean isCustomMessage;

    @Override
    public Boolean isCustomMessage() {
        return isCustomMessage;
    }
}
