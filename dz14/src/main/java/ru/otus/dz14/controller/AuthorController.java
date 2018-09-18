package ru.otus.dz14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.dz14.domain.Author;
import ru.otus.dz14.domain.Book;
import ru.otus.dz14.domain.Comment;
import ru.otus.dz14.repository.AuthorRepository;
import ru.otus.dz14.repository.BookRepository;
import ru.otus.dz14.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, CommentRepository commentRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/authors")
    public String commentsPage(Model model) {

        List<Author> authors = authorRepository.findAll();
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


        model.addAttribute("authors", authors);
//        BookDto bookDto = new BookDto();
//        model.addAttribute("bookDto", bookDto);
        return "authors";
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
