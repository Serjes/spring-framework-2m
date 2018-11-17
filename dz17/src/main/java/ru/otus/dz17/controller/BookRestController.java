package ru.otus.dz17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.dz17.dto.BookDto;

@RestController
public class BookRestController {

    private final LibraryService libraryService;

    @Autowired
    public BookRestController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/api/books")
    public Book addBook(
            @RequestBody BookDto bookDto
    ) {
        Book book = libraryService.addBook(bookDto.getBookTitle(),  bookDto.getAuthorName(),
                bookDto.getAuthorLastName(), bookDto.getGenre());
        return book;
    }

    @DeleteMapping("/api/books/{id}")
    public Book delBook(
            @RequestBody BookDto bookDto
    ) {
        libraryService.delBook(bookDto.getId());
        Book book = new Book();
        return book;
    }

    @PutMapping("/api/books/{id}")
    public Book updateBook(
            @RequestBody BookDto bookDto,
            @PathVariable("id") Integer id
    ) {
        Book book = libraryService.updateBook(id, bookDto.getBookTitle(),
                bookDto.getAuthorName(), bookDto.getAuthorLastName(),
                bookDto.getGenre());
        return book;
    }

}
