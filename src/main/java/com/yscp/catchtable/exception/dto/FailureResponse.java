package com.yscp.catchtable.exception.dto;

import org.springframework.http.HttpStatus;

public record FailureResponse(
        HttpStatus httpStatus,
        String errorCode,
        String message
) {

}
