package com.library.shelf.app.domain;

import java.util.UUID;

class Book {
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

    public static Book of(Snapshot snapshot) {
        return new Book(snapshot.getId(), snapshot.getIsbn(), snapshot.getTitle(), snapshot.getAuthor());
    }

    static Book create(Isbn isbn, Title title, Author author) {
        return new Book(UUID.randomUUID(), isbn, title, author);
    }

    UUID id() {
        return id;
    }

    public Snapshot toSnapshot() {
        return new Snapshot()
                .setId(id)
                .setIsbn(isbn)
                .setTitle(title)
                .setAuthor(author);
    }

    public static class Snapshot {
        private UUID id;
        private Isbn isbn;
        private Title title;
        private Author author;

        public UUID getId() {
            return id;
        }

        public Snapshot setId(UUID id) {
            this.id = id;
            return this;
        }

        public Isbn getIsbn() {
            return isbn;
        }

        public Snapshot setIsbn(Isbn isbn) {
            this.isbn = isbn;
            return this;
        }

        public Title getTitle() {
            return title;
        }

        public Snapshot setTitle(Title title) {
            this.title = title;
            return this;
        }

        public Author getAuthor() {
            return author;
        }

        public Snapshot setAuthor(Author author) {
            this.author = author;
            return this;
        }
    }
}
