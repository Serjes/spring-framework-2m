package ru.otus.dz10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.dz10.domain.Book;
import ru.otus.dz10.domain.Comment;
import ru.otus.dz10.repository.BookRepository;
import ru.otus.dz10.repository.CommentRepository;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void add(String content, int bookId) {
        Book book = bookRepository.getById(bookId);
        Comment comment = new Comment(content, book);
        commentRepository.insert(comment);
    }

    @Override
    public void listByBook(int bookId) {
        Book book = bookRepository.getById(bookId);
        List<Comment> comments = commentRepository.getAllByBook(book);
        if (comments.isEmpty()) {
            System.out.println("нет комментариев к книге \"" + book.getName() + "\"");
            return;
        }
        System.out.println("Комментарии к книге \"" + book.getName() + "\":");
        int i = 1;
        for (Comment comment : comments) {
            System.out.println(i + ") " + comment.getContent());
            i++;
        }
    }
}
