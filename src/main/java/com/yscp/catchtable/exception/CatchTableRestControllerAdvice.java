package com.yscp.catchtable.exception;

import com.yscp.catchtable.exception.dto.FailureResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class CatchTableRestControllerAdvice {
    @ExceptionHandler(CatchTableException.class)
    public ResponseEntity<FailureResponse> handleBadRequestException(CatchTableException exception) {
        return ResponseEntity
                .status(exception.statusCode())
                .body(new FailureResponse(exception.statusCode(),
                        exception.errorCode(),
                        exception.getMessage()));
    }
}
