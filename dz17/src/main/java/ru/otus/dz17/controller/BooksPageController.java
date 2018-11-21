package ru.otus.dz17.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.dz17.dto.BookDto;

@Controller
public class BooksPageController {

    @GetMapping("/books-page")
    public String booksPage(Model model) {
        BookDto bookDto = new BookDto();
        model.addAttribute("bookDto", bookDto);
        return "books";
    }

}
