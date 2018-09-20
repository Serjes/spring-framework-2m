package ru.otus.dz14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.dz14.domain.Book;
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
        List<Comment> allComments = commentRepository.findAll();
        model.addAttribute("comments", allComments);
        return "comments";
    }

    @GetMapping("/comments/list")
    public String commentsByBookPage(
            @RequestParam("id") Integer id,
            Model model
    ) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            List<Comment> allByBook = commentRepository.findAllByBook(optionalBook.get());
            model.addAttribute("comments", allByBook);
            model.addAttribute("bookTitle", optionalBook.get().getTitle());
            CommentDto commentDto = new CommentDto();
            commentDto.setBookId(id);
            model.addAttribute("commentDto", commentDto);
            model.addAttribute("bookId", optionalBook.get().getId());
        }
        return "comments";
    }

    @RequestMapping(
            value = {"/comments/add"},
            method = RequestMethod.POST
    )
    public String saveBook(
            @ModelAttribute("commentDto") CommentDto commentDto
    ) {
        commentService.add(commentDto.getCommentContent(), commentDto.getBookId());
        return "redirect:/comments/list?id=" + commentDto.getBookId();
    }

    @RequestMapping(
            value = {"/comments/add/{id}"},
            method = RequestMethod.POST
    )
    public String updateBook(
            @ModelAttribute("commentDto") CommentDto commentDto,
            @PathVariable("id") Integer id
    ) {
        commentService.updateComment(id, commentDto.getCommentContent());
        return "redirect:/comments/list?id=" + commentDto.getBookId();
    }

    @PostMapping("/comments/delete/")
    public String delete(
            @ModelAttribute("commentDto") CommentDto commentDto
    ) {
        Optional<Comment> optionalComment = commentRepository.findById(commentDto.getId());
        if (optionalComment.isPresent()){
            commentRepository.delete(optionalComment.get());
        }
        int id = optionalComment.get().getBook().getId();
        return "redirect:/comments/list?id=" + id;
    }
}
