package ru.otus.dz17.service;

import com.mongodb.Mongo;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.dz17.domain.Author;
import ru.otus.dz17.domain.Book;
import ru.otus.dz17.domain.Genre;
import ru.otus.dz17.repository.AuthorRepository;
import ru.otus.dz17.repository.BookRepository;
import ru.otus.dz17.repository.GenreRepository;

import java.util.List;

//import ru.otus.dz12.dao.AuthorDao;
//import ru.otus.dz12.dao.BookDao;
//import ru.otus.dz12.dao.GenreDao;

@Service
//@Transactional(readOnly = true)
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthorRepository authorRepository;


    //    @Override
//    public void addTemplateBook() {
//        addBook("Азазель", "Борис","Акунин", "детектив");
//    }
//
    @Override
//    @Transactional
    public Mono<Book> addBook(String tittle, String authorName, String authorLastName, String genreName) {
//        Mono<Author> authorMono = authorRepository.findByFirstNameAndLastName(authorName, authorLastName);
//        Author author = authorMono.block();
////        Author author = null;
////        author = (Author) authorMono.subscribe();
////        authorMono.subscribe(
////
////        );
//        if (author == null) {
//            author = new Author(authorName, authorLastName);
//            authorMono = authorRepository.save(author);
//        }
//        Mono<Genre> genreMono = genreRepository.findByName(genreName);
//        Genre genre = genreMono.block();
//        if (genre == null) {
//            genre = new Genre(genreName);
//            genreMono = genreRepository.save(genre);
//        }
//        Book book = new Book(tittle, authorMono.block(), genreMono.block());
//        System.out.printf(book.toString());
//        return bookRepository.save(book);

//        authorRepository.addBook(author,book);
//        Mono.justOrEmpty(genreRepository.findByName(genreName)).or(new Author(authorName, authorLastName))

//        return Mono.zip(
//                (authorRepository.findByFirstNameAndLastName(authorName, authorLastName)).or(Mono.just(new Author(authorName, authorLastName))),
//                (genreRepository.findByName(genreName)).or(Mono.just(new Genre(genreName))),
//                (author, genre) -> new Book(tittle, author, genre)
//        ).flatMap(book -> bookRepository.save(book));

//        return Mono.zip(
//                authorRepository.findByFirstNameAndLastName(authorName, authorLastName),
//                genreRepository.findByName(genreName),
//                (author, genre) -> new Book(tittle, author, genre)
//        ).flatMap(book -> bookRepository.save(book));

        return Mono.zip(
                (authorRepository.findByFirstNameAndLastName(authorName, authorLastName))
                        .or(authorRepository.save(new Author(authorName, authorLastName))),
                (genreRepository.findByName(genreName))
                        .or(genreRepository.save(new Genre(genreName))),
                (author, genre) -> new Book(tittle, author, genre)
        ).flatMap(book -> bookRepository.save(book));

    }

    @Override
    public Flux<Book> listBooks() {
//        Flux<Book> books = bookRepository.findAll();
//        return books;
        return bookRepository.findAll();
//        System.out.println("Все книги находящиеся в библиотеке:");
//        printBooks(books);
    }

//    @Override
//    public void listBooksByAuthorLastName(String authorLastName) {
////        List<Book> books = authorRepository.findAllBooksByAuthorLastName(authorLastName);
//        List<Book> books = authorRepository.findAllBooksByAuthorLastName(authorLastName);
//        System.out.println("Все книги автора " + authorLastName + " находящиеся в библиотеке:");
//        printBooks(books);
//    }

//    private void printBooks(List<Book> books){
//        int number = 0;
//        for (Book book : books) {
//            number ++;
//            System.out.println("№ " + number + ", название: \"" + book.getTittle() +
//                    "\", автор: " + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName() +
//                    ", жанр: " + book.getGenre().getName());
//        }
//    }

//    @Override
//    public void count() {
//        System.out.println(bookRepository.count());
//    }
//
//    @Override
//    @Transactional
//    public void delBook(int number) {
//        List<Book> books = bookRepository.findAll();
//        bookRepository.delete(books.get(number - 1));
//    }
//
//    @Override
//    public void printAuthorId(String name, String lastName) {
//        System.out.println("id: " + authorRepository.findByFirstNameAndLastName(name, lastName).getId());
//    }
//
//    @Override
//    public void listAuthors() {
//        List<Author> authors = authorRepository.findAll();
//        for (Author author : authors) {
//            System.out.println("Автор: " + author.getFirstName() + " " + author.getLastName());
//        }
//    }

}
