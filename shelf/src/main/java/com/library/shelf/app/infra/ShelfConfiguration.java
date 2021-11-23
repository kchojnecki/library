package com.library.shelf.app.infra;

import com.library.shelf.app.domain.AddBook;
import com.library.shelf.app.domain.BookGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ShelfConfiguration {

    @Bean
    BookGateway bookGateway() {
        return null;
    }

    @Bean
    AddBook addBook(BookGateway bookGateway) {
        return new AddBook(bookGateway);
    }
}
