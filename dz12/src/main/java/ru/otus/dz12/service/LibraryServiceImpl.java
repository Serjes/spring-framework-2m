package ru.otus.dz12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import ru.otus.dz12.dao.AuthorDao;
//import ru.otus.dz12.dao.BookDao;
//import ru.otus.dz12.dao.GenreDao;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.dz12.domain.Author;
import ru.otus.dz12.domain.Book;
import ru.otus.dz12.domain.Genre;
import ru.otus.dz12.repository.AuthorRepository;
import ru.otus.dz12.repository.BookRepository;
import ru.otus.dz12.repository.GenreRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public void addTemplateBook() {
        addBook("Азазель", "Борис","Акунин", "детектив");
    }

    @Override
    @Transactional
    public void addBook(String tittle, String authorName, String authorLastName, String genreName) {
        Author author = authorRepository.findByFirstNameAndLastName(authorName, authorLastName);
        if (author == null) {
            author = new Author(authorName, authorLastName);
            authorRepository.save(author);
        }
        Genre genre = genreRepository.findByName(genreName);
        if (genre == null) {
            genre = new Genre(genreName);
            genreRepository.save(genre);
        }
        Book book = new Book(tittle, author, genre);
        bookRepository.save(book);
        authorRepository.addBook(author,book);
    }

    @Override
    public void listBooks() {
        List<Book> books = bookRepository.findAll();
        System.out.println("Все книги находящиеся в библиотеке:");
        printBooks(books);
    }

    @Override
    public void listBooksByAuthorLastName(String authorLastName) {
        List<Book> books = authorRepository.findAllBooksByAuthorLastName(authorLastName);
        System.out.println("Все книги автора " + authorLastName + " находящиеся в библиотеке:");
        printBooks(books);
    }

    private void printBooks(List<Book> books){
        int number = 0;
        for (Book book : books) {
            number ++;
            System.out.println("№ " + number + ", название: \"" + book.getTittle() +
                    "\", автор: " + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName() +
                    ", жанр: " + book.getGenre().getName());
        }
    }

    @Override
    public void count() {
        System.out.println(bookRepository.count());
    }

    @Override
    @Transactional
    public void delBook(int number) {
        List<Book> books = bookRepository.findAll();
        bookRepository.delete(books.get(number - 1));
    }

    @Override
    public void printAuthorId(String name, String lastName) {
        System.out.println("id: " + authorRepository.findByFirstNameAndLastName(name, lastName).getId());
    }

    @Override
    public void listAuthors() {
        List<Author> authors = authorRepository.findAll();
        for (Author author : authors) {
            System.out.println("Автор: " + author.getFirstName() + " " + author.getLastName());
        }
    }

}
