package ru.otus.dz10.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.otus.dz10.domain.Book;
import ru.otus.dz10.domain.Comment;

import java.util.List;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Integer> {

    List<Comment> findAllByBook(Book book);

    Page<Comment> findAll();
}
