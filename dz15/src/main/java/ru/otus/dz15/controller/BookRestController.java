package ru.otus.dz15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.dz15.domain.Book;
import ru.otus.dz15.dto.BookDto;
import ru.otus.dz15.service.LibraryService;

import java.util.List;

@RestController
public class BookRestController {

    private final LibraryService libraryService;

    @Autowired
    public BookRestController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/api/books")
    public Book addBook(
//    public BookDto addBook(
            @RequestBody BookDto bookDto
    ) {
        Book book = libraryService.addBook(bookDto.getBookTitle(),  bookDto.getAuthorName(),
                bookDto.getAuthorLastName(), bookDto.getGenre());
//        List<Book> books = libraryService.listBooks();
//        return BookDto.toDto(book);
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
