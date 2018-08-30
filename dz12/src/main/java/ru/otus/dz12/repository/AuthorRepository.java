package ru.otus.dz12.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import ru.otus.dz12.domain.Author;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, String> {

    Author findByName(String name);

    List<Author> findAll();
}
