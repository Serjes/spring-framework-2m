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

@Transactional
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void add(String content, Integer bookId) {
        Optional<Book> bookOp = bookRepository.findById(bookId);
        if(bookOp.isPresent()){
            Comment comment = new Comment(content, bookOp.get());
            commentRepository.save(comment);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void listByBook(Integer bookId) {
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
    public void updateComment(Integer id, String commentContent) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()){
            Comment comment = optionalComment.get();
            comment.setContent(commentContent);
            commentRepository.save(comment);
        }
    }
}
