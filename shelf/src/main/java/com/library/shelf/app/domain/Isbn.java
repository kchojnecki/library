package com.library.shelf.app.domain;

public record Isbn(String code) {
    public static Isbn of(String code) {
        return new Isbn(code);
    }
}
