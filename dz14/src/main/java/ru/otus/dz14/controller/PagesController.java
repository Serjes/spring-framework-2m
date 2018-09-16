package ru.otus.dz14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.dz14.domain.Book;
import ru.otus.dz14.repository.BookRepository;

import java.util.List;

@Controller
public class PagesController {

//    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    public PagesController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


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

    @GetMapping("/addbook")
    public String addBookPage(Model model) {
//        List<Book> books = bookRepository.findAll();
//        model.addAttribute("books", books);
        return "addbook";
    }


//    @RequestMapping(
//            value = "/person/",
//            method = RequestMethod.POST
//    )
//    public @ResponseBody PersonDto create(
//            @RequestBody PersonDto dto
//    ) {
//        Person account = PersonDto.toDomainObject(dto);
//        Person accountWithId = repository.save(account);
//        return PersonDto.toDto(accountWithId);
//    }

//    @GetMapping("/authenticated")
//    public String authenticatedPage() {
//        return "authenticated";
//    }

//    return "redirect:/book"
}
