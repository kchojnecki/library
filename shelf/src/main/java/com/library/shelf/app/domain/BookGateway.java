package com.library.shelf.app.domain;

import java.util.Optional;

public interface BookGateway {
    Optional<Book> findByIsbn(Isbn isbn);

    void add(Book book);
}
