package ru.otus.dz12.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.dz12.domain.Author;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, String> {

    Author findByFirstNameAndLastName(String name, String lastName);

    List<Author> findAll();
}
