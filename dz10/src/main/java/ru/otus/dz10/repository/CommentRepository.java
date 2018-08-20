package ru.otus.dz10.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.dz10.domain.Book;
import ru.otus.dz10.domain.Comment;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

//    void insert(Comment c);

    List<Comment> getAllByBook(Book book);
}
