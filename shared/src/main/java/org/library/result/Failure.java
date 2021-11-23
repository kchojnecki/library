package org.library.result;

public record Failure(Reason reason, String message) {
    public enum Reason {
        CONFLICT, FORBIDDEN, NOT_FOUND, UNAUTHORIZED, USER_FAILURE
    }
}
