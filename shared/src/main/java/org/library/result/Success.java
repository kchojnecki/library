package org.library.result;

public record Success<T>(T value) {
    public static Success<Empty> instance() {
        return new Success<>(Empty.instance());
    }

    public static <T> Success<T> of(T value) {
        return new Success<T>(value);
    }
}
