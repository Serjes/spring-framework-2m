package ru.otus.dz17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.dz17.dto.BookDto;

import java.util.List;

@Controller
public class BookController {

    private final LibraryService libraryService;

    @Autowired
    public BookController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/books")
    public String booksPage(Model model) {
        List<Book> books = libraryService.listBooks();
        model.addAttribute("books", books);
        BookDto bookDto = new BookDto();
        model.addAttribute("bookDto", bookDto);
        return "books";
    }

}
