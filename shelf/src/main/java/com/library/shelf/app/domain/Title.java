package com.library.shelf.app.domain;

public record Title(String value) {
    public static Title of(String value) {
        return new Title(value);
    }
}
