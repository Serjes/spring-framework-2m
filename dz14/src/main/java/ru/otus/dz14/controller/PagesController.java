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
    public String booksPage(Model model, int id) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        model.addAttribute("id", id);
        return "books";
    }

    @GetMapping("/books/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
        libraryService.delBook(id);
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
}
