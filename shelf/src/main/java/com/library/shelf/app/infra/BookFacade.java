package com.library.shelf.app.infra;

import com.library.shelf.app.domain.AddBook;
import com.library.shelf.app.domain.AddBookCommand;
import io.vavr.control.Either;
import org.library.result.Failure;
import org.library.result.Success;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookFacade {
    private final AddBook addBook;

    public BookFacade(AddBook addBook) {
        this.addBook = addBook;
    }

    public Either<Failure, Success<UUID>> addBook(AddBookCommand command) {
        return addBook.add(command);
    }
}
