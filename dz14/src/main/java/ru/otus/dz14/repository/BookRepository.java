package ru.otus.dz14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.dz14.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAll();

    Optional<Book> findById(Integer id);

    void deleteById(Integer id);

}
