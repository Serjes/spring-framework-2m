package ru.otus.dz17.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.dz17.domain.Book;

public interface LibraryService {

    Mono<Book> addBook(String name, String author, String authorLastname, String genre);

    Flux<Book> listBooks();

    Mono<Void> delBook(String id);
}
