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

    @PostMapping("/books")
    public Mono<BookDto> addBook(
            @RequestBody BookDto bookDto
    ) {
        Mono<Book> bookMono = libraryService.addBook(bookDto.getBookTitle(),  bookDto.getAuthorName(),
                bookDto.getAuthorLastName(), bookDto.getGenre());
//        return bookMono.flatMap(BookDto::toDto);
//        return bookMono.flatMap(book -> Mono.create(BookDto.toDto(book)));
        return bookMono.map(BookDto::toDto);
    }

//    @GetMapping("/books")
//    public Flux<BookDto> findAll()
//    {
//        return Flux.fromStream(libraryService.listBooks().map(BookDto::toDto));
//    }
    @GetMapping("/books")
    public Flux<BookDto> ListAllBooks(){
//        return libraryService.listBooks().flatMap(book -> {
//
//           return Mono.just(BookDto.toDto(book));
//        });
        return libraryService.listBooks().map(BookDto::toDto);
//        return Flux.fromStream(libraryService.listBooks().toStream().map(BookDto::toDto));
    }
//
    @DeleteMapping("/books/{id}")
    public Mono<Void> delBook(
            @RequestBody BookDto bookDto
    ) {
        return libraryService.delBook(bookDto.getId());
//        Book book = new Book();
////        return book;
//        return Mono.just(book);
    }
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
