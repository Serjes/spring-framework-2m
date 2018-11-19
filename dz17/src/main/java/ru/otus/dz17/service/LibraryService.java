package ru.otus.dz17.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.dz17.domain.Book;

public interface LibraryService {

//    void addTemplateBook();
//
    Mono<Book> addBook(String name, String author, String authorLastname, String genre);

    Flux<Book> listBooks();

//    void listBooksByAuthorLastName(String authorLastName);

//    void count();
//
//    void delBook(int id);
//
//    void printAuthorId(String name, String lastName);
//
//    void listAuthors();
}
