package ru.otus.dz17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.dz17.domain.Book;
import ru.otus.dz17.dto.BookDto;
import ru.otus.dz17.service.LibraryService;

@RestController
public class BookRestController {

    private final LibraryService libraryService;

    @Autowired
    public BookRestController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/books")
    public Mono<BookDto> addBook(
            @RequestBody BookDto bookDto
    ) {
        Mono<Book> bookMono = libraryService.addBook(bookDto.getBookTitle(),  bookDto.getAuthorName(),
                bookDto.getAuthorLastName(), bookDto.getGenre());
        return bookMono.map(BookDto::toDto);
    }

    @GetMapping("/books")
    public Flux<BookDto> ListAllBooks(){
        return libraryService.listBooks().map(BookDto::toDto);
    }

    @DeleteMapping("/books/{id}")
    public Mono<Void> delBook(
            @RequestBody BookDto bookDto
    ) {
        return libraryService.delBook(bookDto.getId());
    }

}
