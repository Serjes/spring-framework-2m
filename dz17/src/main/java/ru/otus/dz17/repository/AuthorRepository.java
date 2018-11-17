package ru.otus.dz17.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.dz17.domain.Author;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, String> {

    Author findByFirstNameAndLastName(String name, String lastName);

    List<Author> findAll();
}
