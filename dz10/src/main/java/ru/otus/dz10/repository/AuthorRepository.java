package ru.otus.dz10.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.dz10.domain.Author;

import java.util.List;
//import ru.otus.dz10.domain.Book;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

    Author findByName(String name);

    List<Author> findAll();
}
