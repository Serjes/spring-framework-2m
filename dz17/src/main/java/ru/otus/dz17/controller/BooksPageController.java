package ru.otus.dz17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import ru.otus.dz17.domain.Book;
import ru.otus.dz17.dto.BookDto;
import ru.otus.dz17.service.LibraryService;

import java.util.List;

@Controller
public class BooksPageController {
//
    private final LibraryService libraryService;

    @Autowired
    public BooksPageController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/books-page")
    public String booksPage(Model model) {
//        Flux<Book> books = libraryService.listBooks();
//        model.addAttribute("books", books);
        BookDto bookDto = new BookDto();
        model.addAttribute("bookDto", bookDto);
        return "books";
    }

//    @GetMapping("/books-index")
//    public String booksIndex(Model model) {
////        Flux<Book> books = libraryService.listBooks();
////        model.addAttribute("books", books);
////        BookDto bookDto = new BookDto();
////        model.addAttribute("bookDto", bookDto);
//        return "books-index";
//    }
}
