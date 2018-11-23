package ru.otus.dz17.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.dz17.domain.Author;
import ru.otus.dz17.domain.Book;
import ru.otus.dz17.domain.Genre;
import ru.otus.dz17.repository.AuthorRepository;
import ru.otus.dz17.repository.BookRepository;
import ru.otus.dz17.repository.GenreRepository;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public Mono<Book> addBook(String tittle, String authorName, String authorLastName, String genreName) {

        return Mono.zip(
                (authorRepository.findByFirstNameAndLastName(authorName, authorLastName))
                        .switchIfEmpty(authorRepository.save(new Author(authorName, authorLastName))),
                (genreRepository.findByName(genreName))
                        .switchIfEmpty(genreRepository.save(new Genre(genreName))),
                (author, genre) -> new Book(tittle, author, genre)
        ).flatMap(book -> bookRepository.save(book));

    }

    @Override
    public Flux<Book> listBooks() {
        Flux<Book> books = bookRepository.findAll();
        return books;
    }

    @Override
    public Mono<Void> delBook(String id) {
        return bookRepository.deleteById(id);
    }

}
