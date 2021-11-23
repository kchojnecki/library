package com.library.webutils.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public final class ErrorDto {
    private final int status;
    private final String message;

    ErrorDto(HttpStatus status, String message) {
        this.status = status.value();
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    ResponseEntity<ErrorDto> toResponseEntity(){
        return ResponseEntity.status(status).body(this);
    }

}
