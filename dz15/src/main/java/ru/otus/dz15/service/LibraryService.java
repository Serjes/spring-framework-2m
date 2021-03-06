package ru.otus.dz15.service;

import ru.otus.dz15.domain.Author;
import ru.otus.dz15.domain.Book;
import ru.otus.dz15.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface LibraryService {

    void addTemplateBook();

    Book addBook(String title, String author, String authorLastname, String genre);

    Book updateBook(Integer id, String title, String author, String authorLastName, String genre);

    List<Book> listBooks();

    List<Author> listAuthors();

    List<Genre> listGenres();

    long count();

    long countAuthors();

    long countGenres();

    Optional<Book> findBookById(Integer id);

    void delBook(Integer id);

    void delAuthor(Integer id);

    void delGenre(Integer id);

    void printAuthorId(String name, String lastName);

}
