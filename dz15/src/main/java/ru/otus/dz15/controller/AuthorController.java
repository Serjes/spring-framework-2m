package ru.otus.dz15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.otus.dz15.domain.Author;
import ru.otus.dz15.service.LibraryService;

import java.util.List;

@Controller
public class AuthorController {

    private final LibraryService libraryService;

    @Autowired
    public AuthorController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/authors")
    public String authorsPage(Model model) {
        return "authors";
    }

}
