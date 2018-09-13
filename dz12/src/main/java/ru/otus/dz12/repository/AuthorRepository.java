package ru.otus.dz12.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.otus.dz12.domain.Author;
import ru.otus.dz12.domain.Book;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, String>, AuthorRepositoryCustom {

    Author findByFirstNameAndLastName(String name, String lastName);

    List<Author> findAll();
}
