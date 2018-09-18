package ru.otus.dz14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.dz14.domain.Book;
import ru.otus.dz14.domain.BookDto;
import ru.otus.dz14.repository.BookRepository;

import java.util.Optional;

@Controller
public class AddBookController {

    private final BookRepository bookRepository;

    @Autowired
    public AddBookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/addbook")
    public String addBookPage(Model model) {
        BookDto bookDto = new BookDto();
        model.addAttribute("bookDto", bookDto);
//        List<Book> books = bookRepository.findAll();
//        model.addAttribute("books", books);
        return "addbook";
    }

    @GetMapping("/addbook/edit")
    public String editBookPage(
//            @ModelAttribute("bookDto") BookDto bookDto,
//            @RequestParam("bookDto") BookDto bookDto,
            @RequestParam("id") Integer id,
//            @PathVariable("id") Integer id,
            Model model
    ) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            BookDto bookDto = BookDto.toDto(bookOptional.get());
            model.addAttribute("bookDto", bookDto);
        }
//        bookOptional.ifPresent(book -> model.addAttribute("book", book));
//        model.addAttribute("books", books);
//        return "redirect:/books";
        return "addbook";
    }
}
