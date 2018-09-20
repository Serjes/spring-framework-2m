package ru.otus.dz14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.otus.dz14.repository.AuthorRepository;
import ru.otus.dz14.repository.BookRepository;
import ru.otus.dz14.repository.GenreRepository;
import ru.otus.dz14.service.LibraryService;

@Controller
public class IndexController {

    private final LibraryService libraryService;

    @Autowired
    public IndexController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }
//    private final BookRepository bookRepository;
//    private final AuthorRepository authorRepository;
//    private final GenreRepository genreRepository;
//
//    @Autowired
//    public IndexController(
//            BookRepository bookRepository,
//            AuthorRepository authorRepository,
//            GenreRepository genreRepository
//            ) {
//        this.bookRepository = bookRepository;
//        this.authorRepository = authorRepository;
//        this.genreRepository = genreRepository;
//    }

    @GetMapping("/")
    public String indexPage(Model model) {
//        model.addAttribute("booksCount", bookRepository.count());
        model.addAttribute("booksCount", libraryService.count());
        model.addAttribute("authorsCount", libraryService.countAuthors());
        model.addAttribute("genresCount", libraryService.countGenres());
        return "index";
    }
}
