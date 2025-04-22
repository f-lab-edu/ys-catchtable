package com.yscp.catchtable.exception;

import org.springframework.http.HttpStatus;

public interface CustomError {
    HttpStatus statusCode();

    String errorCode();

    String message();

    default Boolean isCustomMessage() {
        return false;
    }
}
