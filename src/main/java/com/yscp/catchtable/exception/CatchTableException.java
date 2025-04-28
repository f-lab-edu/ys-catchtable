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
        super(customError.getMessage());
        this.customError = customError;
        this.customMessage = message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return customError.getHttpStatus();
    }

    @Override
    public String getErrorCode() {
        return customError.getErrorCode();
    }

    @Override
    public String getMessage() {
        if (customError.isCustomMessage()) {
            return String.format(customError.getMessage(), customMessage);
        }
        return customError.getMessage();
    }
}
