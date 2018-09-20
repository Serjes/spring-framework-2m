package ru.otus.dz14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.dz14.domain.Author;
import ru.otus.dz14.domain.Book;
import ru.otus.dz14.domain.Comment;
import ru.otus.dz14.repository.AuthorRepository;
import ru.otus.dz14.repository.BookRepository;
import ru.otus.dz14.repository.CommentRepository;
import ru.otus.dz14.service.LibraryService;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthorController {

    private final LibraryService libraryService;

    @Autowired
    public AuthorController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

//    private final AuthorRepository authorRepository;
////    private final CommentRepository commentRepository;
////    private final BookRepository bookRepository;
//
//    @Autowired
//    public AuthorController(AuthorRepository authorRepository) {
//        this.authorRepository = authorRepository;
//    }

//
//    public AuthorController(AuthorRepository authorRepository, CommentRepository commentRepository, BookRepository bookRepository) {
//        this.authorRepository = authorRepository;
//        this.commentRepository = commentRepository;
//        this.bookRepository = bookRepository;
//    }

    @GetMapping("/authors")
    public String commentsPage(Model model) {

//        List<Author> authors = authorRepository.findAll();
        List<Author> authors = libraryService.listAuthors();
        model.addAttribute("authors", authors);
        return "authors";
    }

}
