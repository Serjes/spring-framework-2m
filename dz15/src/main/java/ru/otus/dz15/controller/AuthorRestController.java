package ru.otus.dz15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.dz15.domain.Author;
import ru.otus.dz15.domain.Book;
import ru.otus.dz15.domain.BookDto;
import ru.otus.dz15.service.LibraryService;

import java.util.List;

@RestController
public class AuthorRestController {

    private final LibraryService libraryService;

    @Autowired
    public AuthorRestController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @DeleteMapping("/api/authors/{id}")
    public Author delAuthor(
            @PathVariable("id") Integer id
    ) {
        libraryService.delAuthor(id);
        Author author = new Author();
        return author;
    }

}
