package ru.otus.dz12.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.otus.dz12.domain.Book;
import ru.otus.dz12.domain.Comment;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
//public interface CommentRepository extends PagingAndSortingRepository<Comment, Integer> {

    List<Comment> findAllByBook(Book book);

//    Page<Comment> findAll();
    List<Comment> findAll();
}
