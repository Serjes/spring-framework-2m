package ru.otus.dz14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.dz14.domain.Author;
import ru.otus.dz14.domain.Book;
import ru.otus.dz14.domain.Genre;
import ru.otus.dz14.repository.AuthorRepository;
import ru.otus.dz14.repository.BookRepository;
import ru.otus.dz14.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

//@Transactional
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
        addBook("Азазель", "Борис","Акунин", "детектив");
    }

    @Override
    @Transactional
    public void addBook(String title, String authorName, String authorLastName, String genreName) {
//        Optional<Author> authorOptional = authorRepository.findByName(authorName);
        Optional<Author> authorOptional = authorRepository.findByFirstNameAndLastName(authorName, authorLastName);
        Author author;
        if (!authorOptional.isPresent()) {
//            author = new Author(authorName);
            author = new Author(authorName, authorLastName);
            authorRepository.save(author);
        } else {
            author = authorOptional.get();
        }
        Genre genre = genreRepository.findByName(genreName);
        if (genre == null) {
            genre = new Genre(genreName);
            genreRepository.save(genre);
        }
        Book book = new Book(title, author, genre);
        bookRepository.save(book);
    }

    @Override
    @Transactional(readOnly = true)
    public void listBooks() {
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            System.out.println("ID:" + book.getId() + " название: \"" + book.getTitle() + "\", автор: "
                    + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName()
                    + ", жанр: " + book.getGenre().getName());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void count() {
        System.out.println(bookRepository.count());
    }

    @Override
    @Transactional
    public void delBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public void printAuthorId(String name, String lastName) {
        Optional<Author> authorOptional = authorRepository.findByFirstNameAndLastName(name, lastName);
        String authorNotFound = authorOptional.map(a -> "author ID: " + a.getId())
                .orElse("Такой автор не найден");
        System.out.println(authorNotFound);
//        System.out.println("id: " + authorRepository.findByName(name).getId());
    }

    @Override
    @Transactional(readOnly = true)
    public void listAuthors() {
        List<Author> authors = authorRepository.findAll();
        for (Author author : authors) {
            System.out.println("ID:" + author.getId() + " автор: " + author.getFirstName() + " " + author.getLastName());
        }
    }

}
