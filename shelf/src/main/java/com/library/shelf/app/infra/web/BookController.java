package com.library.shelf.app.infra.web;

import com.library.shelf.app.infra.BookFacade;
import com.library.webutils.response.ResponseMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books/")
class BookController {
    private final BookFacade bookFacade;

    BookController(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @PostMapping
    ResponseEntity<?> addBook(@RequestBody NewBookDto dto) {
        return bookFacade.addBook(dto.toCommand()).fold(ResponseMapper::map, ResponseEntity::ok);
    }
}
