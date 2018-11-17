package ru.otus.dz17.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.dz17.domain.Book;

import java.util.List;
//import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findAll();
}
