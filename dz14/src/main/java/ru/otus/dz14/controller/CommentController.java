package ru.otus.dz14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.dz14.domain.Book;
import ru.otus.dz14.domain.BookDto;
import ru.otus.dz14.domain.Comment;
import ru.otus.dz14.domain.CommentDto;
import ru.otus.dz14.repository.BookRepository;
import ru.otus.dz14.repository.CommentRepository;
import ru.otus.dz14.service.CommentService;

import java.util.List;
import java.util.Optional;

@Controller
public class CommentController {

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentRepository commentRepository, BookRepository bookRepository, CommentService commentService) {
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public String commentsPage(Model model) {
//        List<Book> books = bookRepository.findAll();

//        Page<Comment> allComments = commentRepository.findAll();
        List<Comment> allComments = commentRepository.findAll();
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


        model.addAttribute("comments", allComments);
//        BookDto bookDto = new BookDto();
//        model.addAttribute("bookDto", bookDto);
        return "comments";
    }

    @GetMapping("/comments/list")
    public String commentsByBookPage(
            @RequestParam("id") Integer id,
            Model model){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            List<Comment> allByBook = commentRepository.findAllByBook(optionalBook.get());
            model.addAttribute("comments", allByBook);
            model.addAttribute("bookTitle", optionalBook.get().getTitle());
            model.addAttribute("bookId", optionalBook.get().getId());
        }
        return "comments";
    }

    @RequestMapping(
            value = {"/comments/add"},
            method = RequestMethod.POST
    )
    public String saveBook(
            Model model,
            @ModelAttribute("commentDto") CommentDto commentDto
    ) {
        commentService.add(commentDto.getCommentContent(), commentDto.getBookId());
//        System.out.println("saveBook()");
        return "redirect:/comments/list?id=" + commentDto.getBookId();
    }

    @RequestMapping(
            value = {"/comments/add/{id}"},
            method = RequestMethod.POST
    )
    public String updateBook(
            //Model model,
            @ModelAttribute("commentDto") CommentDto commentDto,
            @PathVariable("id") Integer id
//            @RequestParam("id") Integer id
    ) {
        commentService.updateComment(id, commentDto.getCommentContent());
//        String ret = "redirect:/comments/list?id=" + commentDto.getBookId();
        return "redirect:/comments/list?id=" + commentDto.getBookId();
//        System.out.println(ret);
//        return ret;
    }
}
