package ru.otus.dz14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.otus.dz14.domain.Book;
import ru.otus.dz14.repository.BookRepository;

import java.util.List;

@Controller
public class PagesController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/books")
    public String booksPage(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "books";
    }

//    @GetMapping("/authenticated")
//    public String authenticatedPage() {
//        return "authenticated";
//    }
}
