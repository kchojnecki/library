package com.library.shelf.app.domain;

import io.vavr.control.Either;
import org.library.result.Failure;
import org.library.result.Success;

import java.util.UUID;

import static org.library.result.Failure.Reason.CONFLICT;

public class AddBook {
    private final BookGateway gateway;

    public AddBook(BookGateway gateway) {
        this.gateway = gateway;
    }

    public Either<Failure, Success<UUID>> add(AddBookCommand command) {
        if (gateway.findByIsbn(command.isbn()).isPresent()) {
            var msg = String.format("Book with Isbn:%s already exists.", command.isbn());
            return Either.left(Failure.of(CONFLICT, msg));
        }
        Book book = Book.create(command.isbn(), command.title(), command.author());
        gateway.add(book);
        return Either.right(Success.of(book.id()));
    }
}
