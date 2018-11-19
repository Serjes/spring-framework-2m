package ru.otus.dz17.controller;

import com.mongodb.Mongo;
import com.mongodb.reactivestreams.client.MongoClient;
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

    @PostMapping("/api/books")
    public Mono<Book> addBook(
            @RequestBody BookDto bookDto
    ) {
        Mono<Book> bookMono = libraryService.addBook(bookDto.getBookTitle(),  bookDto.getAuthorName(),
                bookDto.getAuthorLastName(), bookDto.getGenre());
        return bookMono;
    }

//    @GetMapping("/books")
//    public Flux<BookDto> findAll()
//    {
//        return Flux.fromStream(libraryService.listBooks().map(BookDto::toDto));
//    }
//
//    @DeleteMapping("/api/books/{id}")
//    public Book delBook(
//            @RequestBody BookDto bookDto
//    ) {
//        libraryService.delBook(bookDto.getId());
//        Book book = new Book();
//        return book;
//    }
//
//    @PutMapping("/api/books/{id}")
//    public Book updateBook(
//            @RequestBody BookDto bookDto,
//            @PathVariable("id") Integer id
//    ) {
//        Book book = libraryService.updateBook(id, bookDto.getBookTitle(),
//                bookDto.getAuthorName(), bookDto.getAuthorLastName(),
//                bookDto.getGenre());
//        return book;
//    }

}
