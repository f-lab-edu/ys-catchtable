package com.yscp.catchtable.exception;

import org.springframework.http.HttpStatus;

public interface CustomError {
     HttpStatus getHttpStatus();
     String getErrorCode();
     String getMessage();
     default Boolean isCustomMessage() {
        return false;
    }
}
