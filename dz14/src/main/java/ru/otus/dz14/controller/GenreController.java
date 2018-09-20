package ru.otus.dz14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.otus.dz14.domain.Author;
import ru.otus.dz14.domain.Genre;
import ru.otus.dz14.repository.AuthorRepository;
import ru.otus.dz14.repository.BookRepository;
import ru.otus.dz14.repository.CommentRepository;
import ru.otus.dz14.repository.GenreRepository;

import java.util.List;

@Controller
public class GenreController {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("/genres")
    public String commentsPage(Model model) {
        List<Genre> genreList = genreRepository.findAll();
        model.addAttribute("genres", genreList);
        return "genres";
    }

}
