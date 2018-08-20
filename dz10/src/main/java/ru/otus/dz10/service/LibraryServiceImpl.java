package ru.otus.dz10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import ru.otus.dz10.dao.AuthorDao;
//import ru.otus.dz10.dao.BookDao;
//import ru.otus.dz10.dao.GenreDao;
import ru.otus.dz10.domain.Author;
import ru.otus.dz10.domain.Book;
import ru.otus.dz10.domain.Genre;
import ru.otus.dz10.repository.AuthorRepository;
import ru.otus.dz10.repository.BookRepository;
import ru.otus.dz10.repository.GenreRepository;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public void addTemplateBook() {
        addBook("Азазель", "Б.Акунин", "детектив");
    }

    @Override
    public void addBook(String name, String authorName, String genreName) {
        Author author = authorRepository.findByName(authorName);
        if (author == null) {
            author = new Author(authorName);
//            authorRepository.insert(author);
            authorRepository.save(author);
        }
        Genre genre = genreRepository.findByName(genreName);
        if (genre == null) {
            genre = new Genre(genreName);
//            genreRepository.insert(genre);
            genreRepository.save(genre);
        }
        Book book = new Book(name, author, genre);
//        bookRepository.insert(book);
        bookRepository.save(book);
    }

    @Override
    public void listBooks() {
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            System.out.println("ID:" + book.getId() + " название: \"" + book.getName() + "\", автор: "
                    + book.getAuthor().getName() + ", жанр: " + book.getGenre().getName());
        }
    }

    @Override
    public void count() {
        System.out.println(bookRepository.count());
    }

    @Override
    public void delBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void printAuthorId(String name) {
        System.out.println("id: " + authorRepository.findByName(name).getId());
    }

    @Override
    public void listAuthors() {
        List<Author> authors = authorRepository.findAll();
        for (Author author : authors) {
            System.out.println("ID:" + author.getId() + " автор: " + author.getName());
        }
    }

}
