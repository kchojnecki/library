package com.library.shelf.app.domain;

import java.util.UUID;

public class Book {
    private final UUID id;
    private final Isbn isbn;
    private final Title title;
    private final Author author;

    Book(UUID id, Isbn isbn, Title title, Author author) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public static Book create(Isbn isbn, Title title, Author author) {
        return new Book(UUID.randomUUID(), isbn, title, author);
    }
}
