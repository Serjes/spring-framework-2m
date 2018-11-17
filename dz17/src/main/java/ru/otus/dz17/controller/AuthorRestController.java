package ru.otus.dz17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
