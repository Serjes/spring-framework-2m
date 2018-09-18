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
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    @Autowired
    public GenreController(GenreRepository genreRepository, CommentRepository commentRepository, BookRepository bookRepository) {
        this.genreRepository = genreRepository;
//        this.authorRepository = authorRepository;
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/genres")
    public String commentsPage(Model model) {

//        List<Author> authors = authorRepository.findAll();
        List<Genre> genreList = genreRepository.findAll();
//        Page<Comment> allComments = commentRepository.findAll(PageRequest.of(0, 5));
//        int totalPages = allComments.getTotalPages();
//        int pageNumber = 0;
//        do{
//            System.out.println("Страница номер " + (pageNumber + 1));
//            for (Comment comment : allComments
//            ) {
//                System.out.println(comment);
//            }
//            totalPages--;
//            pageNumber++;
//            allComments = commentRepository.findAll(PageRequest.of(pageNumber, 5));
//        }while(totalPages != 0);


        model.addAttribute("genres", genreList);
//        BookDto bookDto = new BookDto();
//        model.addAttribute("bookDto", bookDto);
        return "genres";
    }

//    @GetMapping("/comments/list")
//    public String commentsByBookPage(
//            @RequestParam("id") Integer id,
//            Model model){
//        Optional<Book> optionalBook = bookRepository.findById(id);
//        if (optionalBook.isPresent()) {
//            List<Comment> allByBook = commentRepository.findAllByBook(optionalBook.get());
//            model.addAttribute("comments", allByBook);
//        }
//        return "comments";
//    }
}
