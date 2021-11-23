package com.library.shelf.app.infra.web;

import com.library.shelf.app.domain.AddBookCommand;
import com.library.shelf.app.domain.Author;
import com.library.shelf.app.domain.Isbn;
import com.library.shelf.app.domain.Title;

class NewBookDto {
    private String isbn;
    private String title;
    private AuthorDto author;

    AddBookCommand toCommand() {
        return new AddBookCommand(
                Isbn.of(isbn),
                Title.of(title),
                Author.of(author.name, author.surname)
        );
    }

    public NewBookDto setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public NewBookDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public NewBookDto setAuthor(AuthorDto author) {
        this.author = author;
        return this;
    }

    static class AuthorDto {
        private String name;
        private String surname;

        public AuthorDto setName(String name) {
            this.name = name;
            return this;
        }

        public AuthorDto setSurname(String surname) {
            this.surname = surname;
            return this;
        }
    }
}
