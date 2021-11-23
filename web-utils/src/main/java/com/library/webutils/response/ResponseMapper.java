package com.library.webutils.response;

import org.library.result.Failure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static io.vavr.API.*;
import static org.library.result.Failure.Reason.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

public final class ResponseMapper {
    private ResponseMapper() {
    }

    public static ResponseEntity<ErrorDto> map(final Failure failure) {
        return Match(failure.reason()).of(
                Case($(USER_FAILURE), badRequest(failure)),
                Case($(NOT_FOUND), notFound(failure)),
                Case($(UNAUTHORIZED), unauthorized(failure)),
                Case($(FORBIDDEN), forbidden(failure)),
                Case($(CONFLICT), conflict(failure)));
    }

    private static ResponseEntity<ErrorDto> badRequest(Failure failure) {
        return new ErrorDto(HttpStatus.BAD_REQUEST, failure.message()).toResponseEntity();
    }

    private static ResponseEntity<ErrorDto> notFound(Failure failure) {
        return new ErrorDto(HttpStatus.NOT_FOUND, failure.message()).toResponseEntity();
    }

    private static ResponseEntity<ErrorDto> unauthorized(Failure failure) {
        return new ErrorDto(HttpStatus.UNAUTHORIZED, failure.message()).toResponseEntity();
    }

    private static ResponseEntity<ErrorDto> forbidden(Failure failure) {
        return new ErrorDto(HttpStatus.FORBIDDEN, failure.message()).toResponseEntity();
    }

    private static ResponseEntity<ErrorDto> conflict(Failure failure) {
        return new ErrorDto(HttpStatus.CONFLICT, failure.message()).toResponseEntity();
    }
}
