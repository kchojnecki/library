package org.library.result;

public record Failure(Reason reason, String message) {

    public static Failure of(Reason reason, String message) {
        return new Failure(reason, message);
    }

    public enum Reason {
        CONFLICT, FORBIDDEN, NOT_FOUND, UNAUTHORIZED, USER_FAILURE
    }
}
