package ru.otus.dz14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.otus.dz14.domain.Author;

import java.util.List;
import java.util.Optional;
//import ru.otus.dz14.domain.Book;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

//    Author findByName(String name);
//    Optional<Author> findByName(String name);
    Optional<Author> findByFirstNameAndLastName(String name, String lastName);

    List<Author> findAll();
}
