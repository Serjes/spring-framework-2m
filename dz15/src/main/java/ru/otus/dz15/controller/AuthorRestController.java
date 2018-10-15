package ru.otus.dz15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.dz15.domain.Author;
import ru.otus.dz15.service.LibraryService;

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
