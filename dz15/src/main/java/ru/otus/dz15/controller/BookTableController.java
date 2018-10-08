package ru.otus.dz15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.otus.dz15.domain.Book;
import ru.otus.dz15.domain.BookDto;
import ru.otus.dz15.service.LibraryService;

import java.util.List;

@Controller
public class BookTableController {

    private final LibraryService libraryService;

    @Autowired
    public BookTableController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/books-table")
    public String booksTablePage(Model model) {
        List<Book> books = libraryService.listBooks();
        model.addAttribute("books", books);
        return "books-table";
    }

}
