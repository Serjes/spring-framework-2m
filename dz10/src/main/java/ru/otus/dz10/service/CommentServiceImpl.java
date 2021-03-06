package ru.otus.dz10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.dz10.domain.Book;
import ru.otus.dz10.domain.Comment;
import ru.otus.dz10.repository.BookRepository;
import ru.otus.dz10.repository.CommentRepository;

import java.util.List;

//@Transactional
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    @Transactional
    public void add(String content, int bookId) {
        Book book = bookRepository.findById(bookId);
        Comment comment = new Comment(content, book);
        commentRepository.save(comment);
    }

    @Override
    @Transactional(readOnly = true)
    public void listByBook(int bookId) {
        Book book = bookRepository.findById(bookId);
        List<Comment> comments = commentRepository.findAllByBook(book);
        if (comments.isEmpty()) {
            System.out.println("нет комментариев к книге \"" + book.getTittle() + "\"");
            return;
        }
        System.out.println("Комментарии к книге \"" + book.getTittle() + "\":");
        int i = 1;
        for (Comment comment : comments) {
            System.out.println(i + ") " + comment.getContent());
            i++;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void listAllPages() {

        Page<Comment> allComments = commentRepository.findAll(PageRequest.of(0, 5));
        int totalPages = allComments.getTotalPages();
        int pageNumber = 0;
        do{
            System.out.println("Страница номер " + (pageNumber + 1));
            for (Comment comment : allComments
            ) {
                System.out.println(comment);
            }
            totalPages--;
            pageNumber++;
            allComments = commentRepository.findAll(PageRequest.of(pageNumber, 5));
        }while(totalPages != 0);
    }
}
