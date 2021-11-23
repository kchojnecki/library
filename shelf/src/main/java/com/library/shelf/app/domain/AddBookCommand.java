package com.library.shelf.app.domain;

public record AddBookCommand(Isbn isbn, Title title, Author author) {
}
