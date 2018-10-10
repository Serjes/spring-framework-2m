package ru.otus.dz15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.dz15.domain.Author;
import ru.otus.dz15.domain.Book;
import ru.otus.dz15.domain.BookDto;
import ru.otus.dz15.domain.Genre;
import ru.otus.dz15.service.LibraryService;

import java.util.List;
import java.util.Optional;

@Controller
public class TablesController {

    private final LibraryService libraryService;

    @Autowired
    public TablesController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/books-table")
    public String booksTablePage(Model model) {
        List<Book> books = libraryService.listBooks();
        model.addAttribute("books", books);
        return "books-table";
    }

    @GetMapping("/authors-table")
    public String authorsTablePage(Model model) {
        List<Author> authors = libraryService.listAuthors();
        model.addAttribute("authors", authors);
        return "authors-table";
    }

    @GetMapping("/genres-table")
    public String genresTablePage(Model model) {
        List<Genre> genreList = libraryService.listGenres();
        model.addAttribute("genres", genreList);
        return "genres-table";
    }

    @GetMapping("/editor/{id}")
    public String booksEditorPage(
            @PathVariable("id") Integer id,
            Model model
    ) {
//        List<Genre> genreList = libraryService.listGenres();
//        model.addAttribute("genres", genreList);
        Optional<Book> book = libraryService.findBookById(id);
        model.addAttribute("book", book.get());
        return "editor";
    }

    @GetMapping("/blankeditor")
    public String blankPage(Model model) {
//        List<Book> books = libraryService.listBooks();
//        model.addAttribute("books", books);
        return "editor-blank";
    }
}
