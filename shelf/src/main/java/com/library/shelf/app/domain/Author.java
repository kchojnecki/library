package com.library.shelf.app.domain;

public record Author(String name, String surname) {
    public static Author of(String name, String surname) {
        return new Author(name, surname);
    }
}
