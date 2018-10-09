package ru.otus.dz15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.dz15.domain.Book;
import ru.otus.dz15.domain.BookDto;
import ru.otus.dz15.service.LibraryService;

import java.util.List;

@RestController
public class BookRestController {

    private final LibraryService libraryService;

    @Autowired
    public BookRestController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

//    @GetMapping("/books")
//    public String booksPage(Model model) {
//        List<Book> books = libraryService.listBooks();
//        model.addAttribute("books", books);
////        BookDto bookDto = new BookDto();
////        model.addAttribute("bookDto", bookDto);
//        return "books";
//    }

//    @PostMapping("/books/delete/")
//    public String delete(
//            @ModelAttribute("bookDto") BookDto bookDto
//    ) {
//        libraryService.delBook(bookDto.getId());
//        return "redirect:/books";
//    }
//
    @PostMapping("/api/books")
    public List<Book> addBook(
//            @ModelAttribute("bookDto") BookDto bookDto
            @RequestBody BookDto bookDto
    ) {
        Book book = libraryService.addBook(bookDto.getBookTitle(),  bookDto.getAuthorName(),
                bookDto.getAuthorLastName(), bookDto.getGenre());
        List<Book> books = libraryService.listBooks();
//        return "redirect:/books";
        return books;
    }

    @DeleteMapping("/api/books/{id}")
    public Book delBook(
            @RequestBody BookDto bookDto
//            @RequestParam Integer id
//            @PathVariable("id") Integer id
//            @PathVariable("id") String id
    ) {
//        Book book = libraryService.addBook(bookDto.getBookTitle(),  bookDto.getAuthorName(),
//                bookDto.getAuthorLastName(), bookDto.getGenre());
//        List<Book> books = libraryService.listBooks();
//        return "redirect:/books";
//        System.out.println(id);
//        System.out.println(bookDto.getId());
//        Integer integerId = Integer.valueOf(id);
        libraryService.delBook(bookDto.getId());
        Book book = new Book();
        return book;
    }

//    @PostMapping("/books/add/{id}")
//    public String updateBook(
//            Model model,
//            @ModelAttribute("bookDto") BookDto bookDto,
//            @PathVariable("id") Integer id
//    ) {
//        libraryService.updateBook(id, bookDto.getBookTitle(),
//                bookDto.getAuthorName(), bookDto.getAuthorLastName(),
//                bookDto.getGenre());
//        return "redirect:/books";
//    }
//
//    @GetMapping("/addbook")
//    public String addBookPage(Model model) {
//        BookDto bookDto = new BookDto();
//        model.addAttribute("bookDto", bookDto);
//        return "addbook";
//    }
//
//    @GetMapping("/addbook/edit")
//    public String editBookPage(
//            @RequestParam("id") Integer id,
//            Model model
//    ) {
//        Optional<Book> bookOptional = libraryService.findBookById(id);
//        if (bookOptional.isPresent()) {
//            BookDto bookDto = BookDto.toDto(bookOptional.get());
//            model.addAttribute("bookDto", bookDto);
//        }
//        return "addbook";
//    }
}
