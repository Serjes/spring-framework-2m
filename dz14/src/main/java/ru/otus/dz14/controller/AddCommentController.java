package ru.otus.dz14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.dz14.domain.Book;
import ru.otus.dz14.domain.Comment;
import ru.otus.dz14.domain.CommentDto;
import ru.otus.dz14.repository.BookRepository;
import ru.otus.dz14.repository.CommentRepository;

import java.util.Optional;

@Controller
public class AddCommentController {

    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public AddCommentController(BookRepository bookRepository, CommentRepository commentRepository) {
        this.bookRepository = bookRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/addcomment")
    public String addCommentPage(
            Model model,
            @RequestParam("id") Integer id
    ) {
        CommentDto commentDto = new CommentDto();
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()){
            commentDto.setBookTitle(optionalBook.get().getTitle());
            commentDto.setBookId(optionalBook.get().getId());
        }
        model.addAttribute("commentDto", commentDto);
        model.addAttribute("idBook", id);
        return "addcomment";
    }

    @GetMapping("/addcomment/edit")
    public String editBookPage(
            @RequestParam("id") Integer id,
            Model model
    ) {
        CommentDto commentDto = new CommentDto();
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if(optionalComment.isPresent()) {
            commentDto.setCommentContent(optionalComment.get().getContent());
            commentDto.setBookId(optionalComment.get().getBook().getId());
            commentDto.setId(optionalComment.get().getId());
            model.addAttribute("idBook", optionalComment.get().getBook().getId());
        }
        model.addAttribute("commentDto", commentDto);

        return "addcomment";
    }
}
