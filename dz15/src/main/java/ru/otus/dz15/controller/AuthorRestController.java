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

//    @GetMapping("/authors")
//    public String authorsPage(Model model) {
//        List<Author> authors = libraryService.listAuthors();
//        model.addAttribute("authors", authors);
//        return "authors";
//    }

    @DeleteMapping("/api/authors/{id}")
    public Author delAuthor(
//            @RequestBody BookDto bookDto,
//            @RequestBody String id
//            @RequestParam Integer id
            @PathVariable("id") Integer id
//            @PathVariable String id
//            @PathVariable("id") String id
    ) {
//        System.out.println(id);
//        System.out.println(bookDto.getId());
//        System.out.println(bookDto.getId());
//        Integer integerId = Integer.valueOf(id);
//        libraryService.delBook(bookDto.getId());
        libraryService.delAuthor(id);
        Author author = new Author();
        return author;
    }

}
