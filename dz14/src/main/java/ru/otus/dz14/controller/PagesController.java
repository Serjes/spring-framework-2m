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
public class PagesController {

    //    @Autowired
    private final BookRepository bookRepository;
    private final LibraryService libraryService;

    @Autowired
    public PagesController(BookRepository bookRepository, LibraryService libraryService) {
        this.bookRepository = bookRepository;
        this.libraryService = libraryService;
    }


    @GetMapping("/")
    public String indexPage() {
        return "index";
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
            Model model)
    {
        libraryService.delBook(bookDto.getId());
        return "redirect:/books";
    }


    @GetMapping("/addbook")
    public String addBookPage(Model model) {
        BookDto bookDto = new BookDto();
        model.addAttribute("bookDto", bookDto);
//        List<Book> books = bookRepository.findAll();
//        model.addAttribute("books", books);
        return "addbook";
    }

    @GetMapping("/addbook/id={id}")
    public String editBookPage(
//            @ModelAttribute("bookDto") BookDto bookDto,
//            @RequestParam("bookDto") BookDto bookDto,
//            @RequestParam("id") Integer id,
            @PathVariable("id") Integer id,
            Model model
    ) {

        //BookDto bookDto = new BookDto();
//        model.addAttribute("bookDto", bookDto);
//        List<Book> books = bookRepository.findAll();
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()){
            BookDto bookDto = BookDto.toDto(bookOptional.get());
            model.addAttribute("bookDto", bookDto);
        }
//        bookOptional.ifPresent(book -> model.addAttribute("book", book));
//        model.addAttribute("books", books);
//        return "redirect:/books";
        return "addbook";
    }


    @RequestMapping(
            value = {"/books/add"},
            method = RequestMethod.POST
    )
    public String saveBook(
            Model model,
            @ModelAttribute("bookDto") BookDto bookDto
//            @RequestBody("bookDto") BookDto bookDto
//            @RequestAttribute("bookDto") BookDto bookDto
    ) {
//        Book book = libraryService.
        libraryService.addBook(bookDto.getBookTitle(),
                bookDto.getAuthorName(),
                bookDto.getAuthorLastName(),
                bookDto.getGenre());
        return "redirect:/books";
    }

    @RequestMapping(
            value = {"/books/add/{id}"},
            method = RequestMethod.POST
    )
    public String updateBook(
            Model model,
            @ModelAttribute("bookDto") BookDto bookDto
    ) {
//
//        libraryService.addBook(bookDto.getBookTitle(),
//                bookDto.getAuthorName(),
//                bookDto.getAuthorLastName(),
//                bookDto.getGenre());
        return "redirect:/books";
    }
}
