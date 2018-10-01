package ru.otus.dz14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.dz14.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Optional<Author> findByFirstNameAndLastName(String name, String lastName);

    List<Author> findAll();
}
