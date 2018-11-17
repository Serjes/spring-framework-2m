package ru.otus.dz17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreRestController {

    private final LibraryService libraryService;

    @Autowired
    public GenreRestController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @DeleteMapping("/api/genres/{id}")
    public Genre delGenre(
            @PathVariable("id") Integer id
    ) {
        libraryService.delGenre(id);
        Genre genre = new Genre();
        return genre;
    }

}
