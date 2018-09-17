package ru.otus.dz14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.dz14.domain.Book;
import ru.otus.dz14.domain.Comment;
import ru.otus.dz14.repository.BookRepository;
import ru.otus.dz14.repository.CommentRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

//@Transactional
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    @Transactional
    public void add(String content, Integer bookId) {
//        Book book = bookRepository.findById(bookId);
        Optional<Book> bookOp = bookRepository.findById(bookId);
        if(bookOp.isPresent()){
            Comment comment = new Comment(content, bookOp.get());
            commentRepository.save(comment);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void listByBook(Integer bookId) {
//        Book book = bookRepository.findById(bookId);
        Optional<Book> bookOp = bookRepository.findById(bookId);
        if (bookOp.isPresent()){

            List<Comment> comments = commentRepository.findAllByBook(bookOp.get());
            if (comments.isEmpty()) {
                System.out.println("нет комментариев к книге \"" + bookOp.get().getTitle() + "\"");
                return;
            }
            System.out.println("Комментарии к книге \"" + bookOp.get().getTitle() + "\":");
            int i = 1;
            for (Comment comment : comments) {
                System.out.println(i + ") " + comment.getContent());
                i++;
            }
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
