package ru.otus.dz12.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.dz12.domain.Author;
import ru.otus.dz12.domain.Book;

import java.util.List;

public interface AuthorRepositoryCustom {

    List<Book> findAllBooksByAuthorLastName(String lastName);

    void addBook(Author author, Book book);
}
