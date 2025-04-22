package com.yscp.catchtable.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CatchTableException extends RuntimeException implements CustomError {
    private final CustomError customError;
    private final String customMessage;

    public CatchTableException(CustomError customError) {
        this(customError, "");
    }

    public CatchTableException(CustomError customError, String message) {
        super(customError.message());
        this.customError = customError;
        this.customMessage = message;
    }

    @Override
    public HttpStatus statusCode() {
        return customError.statusCode();
    }

    @Override
    public String errorCode() {
        return customError.errorCode();
    }

    @Override
    public String message() {
        if (customError.isCustomMessage()) {
            return String.format(customError.message(), customMessage);
        }
        return customError.message();
    }
}
