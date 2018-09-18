package ru.otus.dz14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.dz14.domain.Book;
import ru.otus.dz14.domain.BookDto;
import ru.otus.dz14.repository.BookRepository;
import ru.otus.dz14.service.LibraryService;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    //    @Autowired
    private final BookRepository bookRepository;
    private final LibraryService libraryService;

    @Autowired
    public BookController(BookRepository bookRepository, LibraryService libraryService) {
        this.bookRepository = bookRepository;
        this.libraryService = libraryService;
    }

    @GetMapping("/books")
    public String booksPage(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        BookDto bookDto = new BookDto();
        model.addAttribute("bookDto", bookDto);
        return "books";
    }

    @PostMapping("/books/delete/")
    public String delete(
            @ModelAttribute("bookDto") BookDto bookDto,
            Model model) {
        libraryService.delBook(bookDto.getId());
        return "redirect:/books";
    }

    @RequestMapping(
            value = {"/books/add"},
            method = RequestMethod.POST
    )
    public String saveBook(
            Model model,
            @ModelAttribute("bookDto") BookDto bookDto
    ) {
        libraryService.addBook(bookDto.getBookTitle(),  bookDto.getAuthorName(),
                bookDto.getAuthorLastName(), bookDto.getGenre());

        return "redirect:/books";
    }

    @RequestMapping(
            value = {"/books/add/{id}"},
//            value = {"/books/add"},
            method = RequestMethod.POST
    )
    public String updateBook(
            Model model,
            @ModelAttribute("bookDto") BookDto bookDto,
            @PathVariable("id") Integer id
//            @RequestParam("id") Integer id
    ) {
        libraryService.updateBook(id, bookDto.getBookTitle(),
                bookDto.getAuthorName(), bookDto.getAuthorLastName(),
                bookDto.getGenre());
        return "redirect:/books";
    }
}
