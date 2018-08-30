package ru.otus.dz12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.dz12.domain.Book;
import ru.otus.dz12.domain.Comment;
import ru.otus.dz12.repository.BookRepository;
import ru.otus.dz12.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    @Transactional
    public void add(String content, int bookNumber) {
        List<Book> books = bookRepository.findAll();
        Book book = books.get(bookNumber - 1);

        Comment comment = new Comment(content, book);
        commentRepository.save(comment);
    }

    @Override
    public void listByBook(int bookNumber) {
        List<Book> books = bookRepository.findAll();
        Book book = books.get(bookNumber - 1);
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
    public void listAllPages() {

//        List<Comment> comments = commentRepository.findAll();
//        int num = 0;
//        for (Comment comment : comments
//        ) {
//            num++;
//            System.out.println( num + ") " + comment.getContent());
//        }

//        Pageable pageableRequest = new PageRequest(0,5);
        Page<Comment> page = commentRepository.findAll(PageRequest.of(0, 5));
//        List<Comment> comments = page.getContent();
        int totalPages = page.getTotalPages();
        int pageNumber = 0;
        do{
            System.out.println("Страница номер " + (pageNumber + 1));
            for (Comment comment : page
            ) {
                System.out.println(comment);
            }
            totalPages--;
            pageNumber++;
            page = commentRepository.findAll(PageRequest.of(pageNumber, 5));
        }while(totalPages != 0);

    }
}
