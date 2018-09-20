package ru.otus.dz14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.dz14.domain.Book;
import ru.otus.dz14.domain.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByBook(Book book);

    List<Comment> findAll();
}
