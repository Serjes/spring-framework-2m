package ru.otus.dz12.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.dz12.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findAll();

//    Optional<Book> findById(String id);

}
