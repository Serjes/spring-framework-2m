package ru.otus.dz12.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.dz12.domain.Book;
import ru.otus.dz12.domain.Comment;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findAllByBook(Book book);

    List<Comment> findAll();
}
